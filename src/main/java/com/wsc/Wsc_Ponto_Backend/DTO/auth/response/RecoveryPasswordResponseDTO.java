package com.wsc.Wsc_Ponto_Backend.DTO.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecoveryPasswordResponseDTO {

    private boolean isSuccess;
    private String message;
}
