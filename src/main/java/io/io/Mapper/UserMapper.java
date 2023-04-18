package io.io.Mapper;


import io.io.dto.Request.CreateNewUserRequest;
import io.io.dto.Response.UserIdResponse;
import io.io.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper{

    User NewUserRequestToUser(CreateNewUserRequest createNewUserRequest);
    UserIdResponse userToUserIdResponse(User user);
}
