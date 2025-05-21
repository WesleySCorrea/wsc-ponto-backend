package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.LoginResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.UserInfoDTO;

public interface JwtService {
    LoginResponseDTO generateToken(UserInfoDTO user);
    UserInfoDTO validateTokenAndExtractUserInfo(String accessToken);
}
