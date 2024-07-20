package com.dev.miniprj.identityservice.dto.request;

import jakarta.validation.constraints.Size;
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
    @Size(min = 1, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
}
