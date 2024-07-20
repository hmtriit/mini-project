package com.dev.miniprj.identityservice.mapper;

import com.dev.miniprj.identityservice.dto.request.UserCreateRequest;
import com.dev.miniprj.identityservice.dto.request.UserUpdateRequest;
import com.dev.miniprj.identityservice.dto.response.UserResponse;
import com.dev.miniprj.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
