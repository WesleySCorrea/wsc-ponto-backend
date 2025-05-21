package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.service.CryptoService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptoServiceImpl implements CryptoService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encryptPassword(String password) {

        return passwordEncoder.encode(password);
    }

    public void matchesPassword(String rawPassword, String encryptedPassword) {

        if (!passwordEncoder.matches(rawPassword, encryptedPassword)) {
            throw new RuntimeException("Senha incorreta");
        }
    }
}
