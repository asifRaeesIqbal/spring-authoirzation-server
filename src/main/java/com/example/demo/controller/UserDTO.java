package com.example.demo.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.With;

@Builder
@Getter
@Setter
public class UserDTO {

    Long userId;
    String username;
    String authority;
    String password;

}