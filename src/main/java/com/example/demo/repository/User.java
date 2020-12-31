package com.example.demo.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.controller.UserDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String authority;

    static User map(final User user) {
        User entity = new User();
        entity.username = user.getUsername();
        entity.password = user.getPassword();
        entity.authority = user.getAuthority();
        return entity;
    }

   public UserDTO convertToDTO() {
        return UserDTO.builder()
            .userId(id)
            .username(username)
            .password(password)
            .authority(authority)
            .build();
    }
}
