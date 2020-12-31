package com.example.demo.controller;

import lombok.Data;

@Data
class UserPayload {

    private String username;
    private String password;
    private String authority;

    UserDTO map() {
        return UserDTO.builder()
            .username(username)
            .password(password)
            .authority(authority)
            .build()  ;
    }
}
