package com.nguyenngo.userservice.dto;

import lombok.Data;

@Data
public class UserSignUpDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
