package com.dev.miniprj.identityservice.service;

import com.dev.miniprj.identityservice.dto.request.UserCreateRequest;
import com.dev.miniprj.identityservice.dto.request.UserUpdateRequest;
import com.dev.miniprj.identityservice.entity.User;
import com.dev.miniprj.identityservice.exception.AppException;
import com.dev.miniprj.identityservice.exception.ErrorCode;
import com.dev.miniprj.identityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateRequest request) {
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setLastname(request.getLastname());
        user.setFirstname(request.getFirstname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setLastname(request.getLastname());
        user.setFirstname(request.getFirstname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found"));
    }
}
