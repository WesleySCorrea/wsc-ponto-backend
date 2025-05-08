package com.wsc.Wsc_Ponto_Backend.DTO.response;

import lombok.Getter;

import java.time.Instant;

@Getter
public class LoginResponseDTO {

    private String accessToken;
    private String refreshToken;
    private Long userId;
    private String firstName;
    private String email;
    private String role;
    private Long companyId;
    private Instant issuedAt;
    private Instant expiresAt;
}
