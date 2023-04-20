package io.io.service;

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
        return userMapper.userToId(userRepo.save(userMapper.reqToUser(userModelCreateRequest)));
    }

    public UserModel getUser(long userId){
        Optional<User> user= userRepo.findById(userId);
        if(user.isPresent()){
            return userMapper.userToModel(user.get());
        }
        else{
            return null; /* throw exception*/
        }
    }
    public void updateUser(UserModelUpdateRequest userModelUpdateRequest){
        Optional<User> user=userRepo.findById(userModelUpdateRequest.getId());
        if(user.isPresent()){
            User userRetrivied=user.get();
            if(userModelUpdateRequest.getUsername()!=null){
                userRetrivied.setUsername(userModelUpdateRequest.getUsername());
            }
            if(userModelUpdateRequest.getName()!=null){
                userRetrivied.setName(userModelUpdateRequest.getName());

            }
            if(userModelUpdateRequest.getEmail()!=null){
                userRetrivied.setEmail(userModelUpdateRequest.getEmail());

            }
            userRepo.save(userRetrivied);
        }else{
            return ; /*throw exception*/
        }
    }
}
