package com.wsc.Wsc_Ponto_Backend.DTO.auth.request;

import lombok.Getter;

@Getter
public class ChangePasswordRequestDTO {

    private String password;
    private String newPassword;
}