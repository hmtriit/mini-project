package com.dev.miniprj.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class AppException extends RuntimeException {

    private ErrorCode errorCode;

}
