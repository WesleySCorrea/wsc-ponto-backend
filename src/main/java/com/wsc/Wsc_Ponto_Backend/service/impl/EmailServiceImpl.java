package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.RecoveryTokenDTO;
import com.wsc.Wsc_Ponto_Backend.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(RecoveryTokenDTO recovery) {

        String resetPasswordUrl = "http://localhost:8080/recover-password?token=" + recovery.getRecoveryToken() + "&email=" + recovery.getEmail();
        String emailContent = "Clique no link para recuperar sua senha: " + resetPasswordUrl;
    }
}
