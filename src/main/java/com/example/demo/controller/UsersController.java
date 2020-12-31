package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDTO> addUser( @RequestBody final UserPayload payload ) {
        return ResponseEntity.ok(userService.createNewUser(payload.map()));
    }


}
