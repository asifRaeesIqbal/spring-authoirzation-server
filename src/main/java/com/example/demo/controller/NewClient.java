package com.example.demo.controller;

import lombok.Data;

@Data
class NewClient {

    String clientId;
    String secret;
    Integer accessTokenValiditySeconds;
    Integer refreshTokenValiditySeconds;
    String scopes;
    String redirectUris;
    String grantTypes;
    String resourceIds;
    String authorities;

    public ClientDTO map() {
        return ClientDTO.builder()
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
