package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.ChangePasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.UserDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.request.UserRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO save(UserRequestDTO request);
    UserDTO findByEmail(String email);
    void updateNewPassword (String email, String newPassword);
}
