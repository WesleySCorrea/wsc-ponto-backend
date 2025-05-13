package com.wsc.Wsc_Ponto_Backend.controller;

import com.wsc.Wsc_Ponto_Backend.DTO.user.request.UserRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.response.UserResponseDTO;
import com.wsc.Wsc_Ponto_Backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> salvar(@RequestBody @Valid UserRequestDTO request) {

        return ResponseEntity.ok().body(userService.save(request));
    }
}
