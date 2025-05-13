package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.UserDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.response.LoginResponseDTO;

public interface JwtService {
    LoginResponseDTO generateToken(UserDTO user);
    Boolean isTokenValid(String token, UserDTO userDetails);
}
