package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.request.LoginRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.response.LoginResponseDTO;
import com.wsc.Wsc_Ponto_Backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {




        return new LoginResponseDTO();
    }
}
