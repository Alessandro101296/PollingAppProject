package io.io.service;

import io.io.Exception.NoRoleException;
import io.io.Mapper.UserMapper;
import io.io.dto.Request.LogInRequest;
import io.io.dto.Request.SignUpRequest;
import io.io.dto.Response.JwtAuthenticationResponse;
import io.io.entity.Role;
import io.io.entity.RoleName;
import io.io.entity.User;
import io.io.repository.RoleRepository;
import io.io.repository.UserRepository;
import io.io.security.JwtTokenProvider;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class AuthenticationService {

    private JwtTokenProvider tokenProvider;

    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;

    private UserMapper userMapper;

    private RoleRepository roleRepository;

    public AuthenticationService(JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager, UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public JwtAuthenticationResponse login(LogInRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return new JwtAuthenticationResponse(jwt);
    }

    @Transactional
    public void signup(SignUpRequest request) throws NoRoleException {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {

        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {

        }

        User user = userMapper.signUnToUser(request);

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new NoRoleException());

        user.setRoles(Collections.singleton(userRole));

        userRepository.save(user);


    }
}
