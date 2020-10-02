package com.store.mapper;

import com.store.dto.UserResponse;
import com.store.dto.UserRequest;
import com.store.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "id")
    UserResponse userToUserResponse(User user);

    @IterableMapping(elementTargetType = UserResponse.class)
    List<UserResponse> userToUserListResponse(List<User> users);

    void mapUserFromUserRequest (UserRequest userRequest, @MappingTarget User user);

}
