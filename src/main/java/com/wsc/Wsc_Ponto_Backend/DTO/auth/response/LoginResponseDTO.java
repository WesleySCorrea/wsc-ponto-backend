package com.wsc.Wsc_Ponto_Backend.DTO.auth.response;

import com.wsc.Wsc_Ponto_Backend.enuns.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private Long userId;
    private String userName;
    private RoleEnum role;
    private Long accessTokenExpiresIn;
    private Long refreshTokenExpiresIn;
}
