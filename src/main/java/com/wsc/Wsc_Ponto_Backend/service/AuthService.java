package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.ChangePasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.LoginRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.RecoveryPasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.LoginResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.RecoveryPasswordResponseDTO;

public interface AuthService {

    LoginResponseDTO login (LoginRequestDTO request);
    RecoveryPasswordResponseDTO recveryPassword (RecoveryPasswordRequestDTO request);
    void changePassword (ChangePasswordRequestDTO request);
}
