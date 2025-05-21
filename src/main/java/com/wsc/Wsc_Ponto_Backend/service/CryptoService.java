package com.wsc.Wsc_Ponto_Backend.service;

public interface CryptoService {

    String encryptPassword (String password);
    void matchesPassword(String rawPassword, String encryptedPassword);
}
