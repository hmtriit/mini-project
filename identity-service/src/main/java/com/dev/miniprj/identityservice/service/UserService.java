package com.dev.miniprj.identityservice.service;

import com.dev.miniprj.identityservice.dto.request.UserCreateRequest;
import com.dev.miniprj.identityservice.dto.request.UserUpdateRequest;
import com.dev.miniprj.identityservice.dto.response.UserResponse;
import com.dev.miniprj.identityservice.entity.User;
import com.dev.miniprj.identityservice.exception.AppException;
import com.dev.miniprj.identityservice.exception.ErrorCode;
import com.dev.miniprj.identityservice.mapper.UserMapper;
import com.dev.miniprj.identityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public User createUser(UserCreateRequest request) {

        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found")));
    }
}
