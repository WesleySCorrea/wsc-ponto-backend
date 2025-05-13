package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.UserDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.request.UserRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.response.UserResponseDTO;
import com.wsc.Wsc_Ponto_Backend.entity.User;
import com.wsc.Wsc_Ponto_Backend.repository.UserRepository;
import com.wsc.Wsc_Ponto_Backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponseDTO save(UserRequestDTO request) {

        User user = request.toEntity(request);

        user = repository.save(user);

        return new UserResponseDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) {

        User user = repository.findByEmail(email);

        return new UserDTO(user);
    }
}
