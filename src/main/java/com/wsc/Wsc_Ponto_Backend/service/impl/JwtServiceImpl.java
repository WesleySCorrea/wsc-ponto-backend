package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wsc.Wsc_Ponto_Backend.DTO.UserDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.response.LoginResponseDTO;
import com.wsc.Wsc_Ponto_Backend.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    private static final String SECRET_KEY = "WSC-APP-Secrety";
    private static final long EXPIRATION_TIME = 3600000;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 72000000;

    @Override
    public LoginResponseDTO generateToken(UserDTO user) {

        Date accessTokenExpiresAt = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        Date refreshTokenExpiresAt = new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME);

        return new LoginResponseDTO(
                generateAccessToken(user, accessTokenExpiresAt),
                generateRefreshToken(user.getEmail(), user.getId(), refreshTokenExpiresAt),
                "Bearer",
                user.getId(),
                user.getFirstName(),
                user.getRole(),
                accessTokenExpiresAt.getTime(),
                refreshTokenExpiresAt.getTime()
        );
    }

    @Override
    public Boolean isTokenValid(String token, UserDTO userDetails) {
        return null;
    }

    private String generateAccessToken(UserDTO user, Date expirationAt) {

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("email", user.getEmail())
                .withClaim("userId", user.getId())
                .withClaim("firstName", user.getFirstName())
                .withClaim("companyId", user.getCompany().getId())
                .withClaim("companyName", user.getCompany().getCompanyName())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(new Date())
                .withExpiresAt(expirationAt)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    private String generateRefreshToken(String email, Long userId, Date expirationAt) {

        return JWT.create()
                .withSubject(email)
                .withClaim("userId", userId)
                .withIssuedAt(new Date())
                .withExpiresAt(expirationAt)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }
}
