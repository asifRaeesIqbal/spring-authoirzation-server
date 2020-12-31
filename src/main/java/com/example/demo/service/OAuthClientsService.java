package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ClientDTO;
import com.example.demo.repository.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class OAuthClientsService implements ClientDetailsService {

	@Autowired
    private ClientRepository clienRepository;

    @Override
    public ClientDetails loadClientByClientId(final String clientId) throws ClientRegistrationException {
        return clienRepository.findByClientId(clientId)
        	.map(OAuthClientsService::convertToDTO)	
            .map(OAuthClientsService::mapTo)
            .orElseThrow(() ->
                new ClientRegistrationException(
                    String.format("Oauth client not found: clientId=%s", clientId)));

    }

    private static ClientDetails mapTo(final ClientDTO client) {
        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(client.getClientId());
        details.setClientSecret(client.getSecret());
        details.setAuthorizedGrantTypes(convertToSet(client.getGrantTypes()));
        details.setScope(convertToSet(client.getScopes()));
        details.setRegisteredRedirectUri(convertToSet(client.getRedirectUris()));
        details.setResourceIds(convertToSet(client.getResourceIds()));
        details.setAuthorities(convertToSet(client.getAuthorities())
            .stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toUnmodifiableSet()));
        return details;
    }

    private static Set<String> convertToSet(final String pCSVString) {
        return pCSVString != null ?
            Arrays.stream(pCSVString.split(",")).map(String::trim).collect(Collectors.toUnmodifiableSet()) :
            Collections.emptySet();
    }
    
    public static ClientDTO convertToDTO(Client client) {
        return client.convertToDTO();
    }
}
