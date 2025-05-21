package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.RecoveryTokenDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.ChangePasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.LoginRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.RecoveryPasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.LoginResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.RecoveryPasswordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.UserDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.UserInfoDTO;
import com.wsc.Wsc_Ponto_Backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final UserService userService;
    private final EmailService emailService;
    private final RecoveryTokenService recoveryTokenService;
    private final CryptoService cryptoService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {

        //Busca usuario pelo email
        UserDTO userDTO = userService.findByEmail(request.getEmail());

        cryptoService.matchesPassword(request.getPassword(), userDTO.getPassword());

        //Gerar Access Token e Refresh Token
        LoginResponseDTO response = jwtService.generateToken(new UserInfoDTO(userDTO));

        return response;
    }

    @Override
    public RecoveryPasswordResponseDTO recveryPassword(RecoveryPasswordRequestDTO request) {

        UserDTO user = userService.findByEmail(request.getEmail());

        if (user == null) {
            return  new RecoveryPasswordResponseDTO(
                    false,
                    "Email " + request.getEmail() + " não cadastrado na base de dados."
            );
        }

        String recoveryToken = UUID.randomUUID().toString();

        RecoveryTokenDTO recovery = recoveryTokenService.saveRecovery(request, recoveryToken);

        emailService.sendEmail(recovery);

        return new RecoveryPasswordResponseDTO(
                true,
                "Um e-mail foi enviado para " + request.getEmail() + " com as instruções de recuperação de senha."
        );
    }

    @Override
    public void changePassword(ChangePasswordRequestDTO request) {

        UserInfoDTO userInfo = getUserInfoDTO();
        UserDTO userDTO = userService.findByEmail(userInfo.getEmail());

        cryptoService.matchesPassword(request.getPassword(), userDTO.getPassword());

        String newPassword = cryptoService.encryptPassword(request.getNewPassword());

        userService.updateNewPassword(userInfo.getEmail(), newPassword);
    }

    public static UserInfoDTO getUserInfoDTO() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (UserInfoDTO) authentication.getDetails();
    }
}
