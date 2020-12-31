package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.UserDTO;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
    private UserRepository repository;

    @Override
    public UserDTO findByUsername(final String username) {
        return repository.findByUsername(username).get().convertToDTO();                         
    }

}
