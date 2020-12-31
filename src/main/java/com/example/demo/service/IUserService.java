package com.example.demo.service;

import com.example.demo.controller.UserDTO;
import com.example.demo.repository.User;

public interface IUserService {

	UserDTO findByUsername(String pUsername);

}