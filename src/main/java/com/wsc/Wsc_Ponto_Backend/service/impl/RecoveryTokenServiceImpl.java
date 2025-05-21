package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.RecoveryTokenDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.RecoveryPasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.entity.RecoveryToken;
import com.wsc.Wsc_Ponto_Backend.repository.RecoveryTokenRepository;
import com.wsc.Wsc_Ponto_Backend.service.RecoveryTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecoveryTokenServiceImpl implements RecoveryTokenService {

    private final RecoveryTokenRepository repository;

    @Override
    public RecoveryTokenDTO saveRecovery(RecoveryPasswordRequestDTO request, String token) {

        RecoveryToken recoveryToken = request.toEntity(request, token);

        recoveryToken = repository.save(recoveryToken);

        return new RecoveryTokenDTO(recoveryToken);
    }
}
