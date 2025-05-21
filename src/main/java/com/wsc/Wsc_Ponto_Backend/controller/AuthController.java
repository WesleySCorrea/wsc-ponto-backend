package com.wsc.Wsc_Ponto_Backend.controller;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.ChangePasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.LoginRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.RecoveryPasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.LoginResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.RecoveryPasswordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody @Valid LoginRequestDTO request) {

        LoginResponseDTO response = service.login(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("recovery-password")
    public ResponseEntity<RecoveryPasswordResponseDTO> recoveryPassword(@RequestBody @Valid RecoveryPasswordRequestDTO request) {

        RecoveryPasswordResponseDTO response = service.recveryPassword(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("change-password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordRequestDTO request) {

        service.changePassword(request);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken() {

        return ResponseEntity.ok().build();
    }


}