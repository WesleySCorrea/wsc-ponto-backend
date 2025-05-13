package com.wsc.Wsc_Ponto_Backend.DTO.response;

import com.wsc.Wsc_Ponto_Backend.enuns.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private Long userId;
    private String username;
    private RoleEnum role;
    private Long accessTokenExpiresIn;
    private Long refreshTokenExpiresIn;
}
