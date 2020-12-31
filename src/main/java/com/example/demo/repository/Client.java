package com.example.demo.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.controller.ClientDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "client_id", unique = true, nullable = false)
    private String clientId;

    @Column(nullable = false)
    private String secret;

    @Column(name = "access_token_validity")
    Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity")
    Integer refreshTokenValiditySeconds;

    @Column
    private String scopes;

    @Column(name = "redirect_uris")
    String redirectUris;

    @Column(name = "grant_types", nullable = false)
    private String grantTypes;

    @Column(name = "resource_ids")
    String resourceIds;

    @Column
    String authorities; 

    public static Client map(final ClientDTO client) {
        Client entity = new Client();
        entity.id = client.getId();
        entity.clientId = client.getClientId();
        entity.secret = client.getSecret();
        entity.accessTokenValiditySeconds = client.getAccessTokenValiditySeconds();
        entity.refreshTokenValiditySeconds = client.getRefreshTokenValiditySeconds();
        entity.scopes = client.getScopes();
        entity.redirectUris = client.getRedirectUris();
        entity.grantTypes = client.getGrantTypes();
        entity.resourceIds = client.getResourceIds();
        entity.authorities = client.getAuthorities();
        return entity;
    }

    public ClientDTO convertToDTO() {
        return ClientDTO.builder()
            .id(id)
            .clientId(clientId)
            .secret(secret)
            .accessTokenValiditySeconds(accessTokenValiditySeconds)
            .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
            .scopes(scopes)
            .redirectUris(redirectUris)
            .grantTypes(grantTypes)
            .resourceIds(resourceIds)
            .authorities(authorities)
            .build();
    }
}
