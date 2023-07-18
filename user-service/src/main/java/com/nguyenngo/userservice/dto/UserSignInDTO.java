package com.nguyenngo.userservice.dto;

import lombok.Data;

@Data
public class UserSignInDTO {
    private String email;
    private String password;
}
