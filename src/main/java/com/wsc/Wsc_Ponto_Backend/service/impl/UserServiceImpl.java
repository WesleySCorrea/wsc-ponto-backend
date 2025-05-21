package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.auth.request.ChangePasswordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.UserDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.request.UserRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.response.UserResponseDTO;
import com.wsc.Wsc_Ponto_Backend.entity.User;
import com.wsc.Wsc_Ponto_Backend.exceptions.runtime.PersistFailedException;
import com.wsc.Wsc_Ponto_Backend.repository.UserRepository;
import com.wsc.Wsc_Ponto_Backend.service.CryptoService;
import com.wsc.Wsc_Ponto_Backend.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final CryptoService cryptoService;

    @Override
    public UserResponseDTO save(UserRequestDTO request) {

        User user = request.toEntity(request);

        user.setPassword(cryptoService.encryptPassword(request.getPassword()));

        try {
            user = repository.save(user);
        } catch (PersistFailedException e) {
            throw new PersistFailedException("Failed to persist user.");
        }

        return new UserResponseDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) {

        User user = repository.findByEmail(email);

        return new UserDTO(user);
    }

    @Override
    @Transactional
    public void updateNewPassword(String email, String newPassword) {

        repository.updatePassword(email, newPassword);
    }
}
