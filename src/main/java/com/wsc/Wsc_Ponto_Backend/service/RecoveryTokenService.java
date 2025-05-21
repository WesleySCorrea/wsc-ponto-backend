package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.RecoveryTokenDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.RecoveryPasswordRequestDTO;

public interface RecoveryTokenService {

    RecoveryTokenDTO saveRecovery (RecoveryPasswordRequestDTO request, String recoveryToken);
}
