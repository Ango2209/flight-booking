package com.nguyenngo.userservice.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String numberPhone;
}
