package io.io.Mapper;

import io.io.dto.Response.IdResponse;
import io.io.dto.Request.UserModelCreateRequest;
import io.io.dto.Response.UserModel;
import io.io.dto.Request.UserModelUpdateRequest;
import io.io.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper  {

    IdResponse userToId(User user);

    UserModel userToModel(User user);

    User reqToUser(UserModelCreateRequest userModelCreateRequest);

    User reqUpdateToUser(UserModelUpdateRequest userModelUpdateRequest);
}
