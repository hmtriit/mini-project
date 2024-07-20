package com.dev.miniprj.identityservice.controller;

import com.dev.miniprj.identityservice.dto.request.ApiResponse;
import com.dev.miniprj.identityservice.dto.request.UserCreateRequest;
import com.dev.miniprj.identityservice.dto.request.UserUpdateRequest;
import com.dev.miniprj.identityservice.entity.User;
import com.dev.miniprj.identityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreateRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
       return apiResponse;
    }

    @GetMapping
    List<User>getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
