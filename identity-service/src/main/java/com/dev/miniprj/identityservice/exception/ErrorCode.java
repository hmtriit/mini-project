package com.dev.miniprj.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(1001, "Invalid message key"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "Username must be at least 1 characters"),
    INVALID_PASSWORD(1004, "Password must be at least 8 characters")

    ;
    private int code;
    private String message;
}
