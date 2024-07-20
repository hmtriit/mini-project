package com.dev.miniprj.identityservice.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequest {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
}
