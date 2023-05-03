package io.io.security;

import io.io.Exception.NoUserException;
import io.io.entity.User;
import io.io.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
            User user= userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow(()-> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));
            return UserPrincipal.create(user);

    }

    @Transactional
    public UserDetails loadUserById(long userId) throws NoUserException {
        User user=userRepository.findById(userId).orElseThrow(()->new NoUserException());
        return  UserPrincipal.create(user);
    }
}
