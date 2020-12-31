package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ClientDTO;
import com.example.demo.repository.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService implements IClientService {

	@Autowired
    private ClientRepository repository;

    @Override
    public ClientDTO findByClientId(final String clientId) {
        return repository.findByClientId(clientId).get().convertToDTO();
    }
    
    @Override
    public ClientDTO createNewClient(final ClientDTO client) {
    	Client newClient = Client.map(client);
        return repository.save(newClient).convertToDTO();
    }
}
