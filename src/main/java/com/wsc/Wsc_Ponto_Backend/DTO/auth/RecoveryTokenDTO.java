package com.wsc.Wsc_Ponto_Backend.DTO.auth;

import com.wsc.Wsc_Ponto_Backend.entity.RecoveryToken;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RecoveryTokenDTO {

    private String email;

    private String recoveryToken;

    private LocalDateTime expiration;

    public RecoveryTokenDTO (RecoveryToken recoveryToken) {
        this.email = recoveryToken.getEmail();
        this.recoveryToken = recoveryToken.getRecoveryToken();
        this.expiration = recoveryToken.getExpiration();
    }
}
