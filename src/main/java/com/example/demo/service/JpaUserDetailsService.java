package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.demo.controller.UserDTO;

import lombok.RequiredArgsConstructor;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(final String username) {        
        UserDTO findByUsername = service.findByUsername(username);
        return new SecurityUser(findByUsername);
    }
}
