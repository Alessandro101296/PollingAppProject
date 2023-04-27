package io.io.service;

import io.io.Exception.NoUserException;
import io.io.Mapper.UserMapper;
import io.io.dto.IdResponse;
import io.io.dto.UserModelCreateRequest;
import io.io.dto.UserModel;
import io.io.dto.UserModelUpdateRequest;
import io.io.entity.User;
import io.io.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    private final UserMapper userMapper;


    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public IdResponse createUser(UserModelCreateRequest userModelCreateRequest){
        /*gestire eccezione con i natural id*/
        return userMapper.userToId(userRepo.save(userMapper.reqToUser(userModelCreateRequest)));
    }

    public UserModel getUser(long userId) throws NoUserException {
        User user= userRepo.findById(userId).orElseThrow(()-> new NoUserException());
        return userMapper.userToModel(user);
    }
    public void updateUser(UserModelUpdateRequest userModelUpdateRequest) throws NoUserException {
        User user=userRepo.findById(userModelUpdateRequest.getId()).orElseThrow(()->new NoUserException());
        if(userModelUpdateRequest.getUsername()!=null){
            user.setUsername(userModelUpdateRequest.getUsername());
        }
        if(userModelUpdateRequest.getName()!=null){
            user.setName(userModelUpdateRequest.getName());

        }
        if(userModelUpdateRequest.getEmail()!=null){
            user.setEmail(userModelUpdateRequest.getEmail());

        }
        userRepo.save(user);
    }

}
