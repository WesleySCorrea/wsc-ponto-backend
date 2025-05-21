package com.wsc.Wsc_Ponto_Backend.DTO.auth.request;

import com.wsc.Wsc_Ponto_Backend.entity.RecoveryToken;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RecoveryPasswordRequestDTO {

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;


    public RecoveryToken toEntity (RecoveryPasswordRequestDTO request, String token) {
        RecoveryToken recovery = new RecoveryToken();
        recovery.setEmail(request.getEmail());
        recovery.setRecoveryToken(token);
        recovery.setExpiration(LocalDateTime.now().plusMinutes(15));

        return recovery;
    }
}
