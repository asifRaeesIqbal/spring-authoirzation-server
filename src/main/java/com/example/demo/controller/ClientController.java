package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Client;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
    private ClientService service;

    @PostMapping("")
    public ResponseEntity<Client> addClient(
        @RequestBody final NewClient payload) {

        return ResponseEntity.ok(service.createNewClient(payload.map()));
    }


}