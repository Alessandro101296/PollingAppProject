package io.io.service;

import io.io.Exception.ExistingUsernameException;
import io.io.Mapper.UserMapper;
import io.io.dto.Request.CreateNewUserRequest;
import io.io.dto.Response.UserIdResponse;
import io.io.entity.User;
import io.io.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository,UserMapper userMapper){
        this.userRepository=userRepository;
        this.userMapper=userMapper;
    }

    public UserIdResponse createNewUser(CreateNewUserRequest createNewUserRequest) throws ExistingUsernameException {
        if(userRepository.findByUsername(createNewUserRequest.getUsername()).isPresent()){
            throw new ExistingUsernameException();
        }
        User createdUser=userRepository.save(userMapper.NewUserRequestToUser(createNewUserRequest));
        UserIdResponse response=userMapper.userToUserIdResponse(createdUser);
        return response;
    }
}
