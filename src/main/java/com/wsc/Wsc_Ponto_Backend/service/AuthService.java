package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.request.LoginRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.response.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login (LoginRequestDTO request);
}
