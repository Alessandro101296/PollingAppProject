package io.io.Mapper;

import io.io.dto.IdResponse;
import io.io.dto.UserModelCreateRequest;
import io.io.dto.UserModel;
import io.io.dto.UserModelUpdateRequest;
import io.io.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper  {

    IdResponse userToId(User user);

    @Mapping(target = "voteList",ignore = true)
    @Mapping(target = "pollList",ignore = true)
    UserModel userToModel(User user);

    User reqToUser(UserModelCreateRequest userModelCreateRequest);

    User reqUpdateToUser(UserModelUpdateRequest userModelUpdateRequest);
}
