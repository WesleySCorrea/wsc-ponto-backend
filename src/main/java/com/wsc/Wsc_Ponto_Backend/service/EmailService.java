package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.RecoveryTokenDTO;

public interface EmailService {

    void sendEmail (RecoveryTokenDTO recovery);
}
