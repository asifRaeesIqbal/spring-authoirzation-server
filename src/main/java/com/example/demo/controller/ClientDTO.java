package com.example.demo.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

@Builder
@Getter
@Setter
public class ClientDTO {

    Long id;
    String clientId;
    @With
    String secret;
    Integer accessTokenValiditySeconds;
    Integer refreshTokenValiditySeconds;

    String scopes;       // CSV
    String redirectUris;  // CSV
    String grantTypes;   // CSV
    String resourceIds;  // CSV
    String authorities;  // CSV
}

