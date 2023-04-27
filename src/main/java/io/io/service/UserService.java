package io.io.service;

import io.io.Exception.NoUserException;
import io.io.Mapper.UserMapper;
import io.io.dto.Response.IdResponse;
import io.io.dto.Request.UserModelCreateRequest;
import io.io.dto.Response.UserModel;
import io.io.dto.Request.UserModelUpdateRequest;
import io.io.entity.User;
import io.io.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public IdResponse createUser(UserModelCreateRequest userModelCreateRequest){
        /*gestire eccezione con i natural id*/
        return userMapper.userToId(userRepository.save(userMapper.reqToUser(userModelCreateRequest)));
    }

    public UserModel getUser(long userId) throws NoUserException {
        User user= userRepository.findById(userId).orElseThrow(()-> new NoUserException());
        return userMapper.userToModel(user);
    }
    public void updateUser(UserModelUpdateRequest userModelUpdateRequest) throws NoUserException {
        User user= userRepository.findById(userModelUpdateRequest.getId()).orElseThrow(()->new NoUserException());
        if(userModelUpdateRequest.getUsername()!=null){
            user.setUsername(userModelUpdateRequest.getUsername());
        }
        if(userModelUpdateRequest.getName()!=null){
            user.setName(userModelUpdateRequest.getName());

        }
        if(userModelUpdateRequest.getEmail()!=null){
            user.setEmail(userModelUpdateRequest.getEmail());

        }
        userRepository.save(user);
    }

}
