package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.UserDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.request.UserRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO save(UserRequestDTO request);
    UserDTO findByEmail(String email);

}
