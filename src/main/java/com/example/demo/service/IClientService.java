package com.example.demo.service;

import com.example.demo.controller.ClientDTO;

public interface IClientService {

	ClientDTO findByClientId(String pClientId);

	ClientDTO createNewClient(ClientDTO client);

}
