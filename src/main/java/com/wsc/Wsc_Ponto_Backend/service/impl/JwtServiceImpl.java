package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wsc.Wsc_Ponto_Backend.DTO.auth.response.LoginResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.UserInfoDTO;
import com.wsc.Wsc_Ponto_Backend.enuns.RoleEnum;
import com.wsc.Wsc_Ponto_Backend.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    private static final String SECRET_KEY = "WSC-APP-Secrety";
    private static final long EXPIRATION_TIME = 3600000;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 72000000;

    @Override
    public LoginResponseDTO generateToken(UserInfoDTO user) {

        Date accessTokenExpiresAt = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        Date refreshTokenExpiresAt = new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME);

        return new LoginResponseDTO(
                generateAccessToken(user, accessTokenExpiresAt),
                generateRefreshToken(user.getEmail(), user.getUserId(), refreshTokenExpiresAt),
                "Bearer",
                user.getUserId(),
                user.getName(),
                user.getRole(),
                accessTokenExpiresAt.getTime(),
                refreshTokenExpiresAt.getTime()
        );
    }

    @Override
    public UserInfoDTO validateTokenAndExtractUserInfo(String accessToken) {

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build();

        DecodedJWT decodedJWT = verifier.verify(accessToken);

        return new UserInfoDTO(
                decodedJWT.getClaim("userId").asLong(),
                decodedJWT.getClaim("firstName").toString(),
                decodedJWT.getSubject(),
                decodedJWT.getClaim("companyId").asLong(),
                decodedJWT.getClaim("companyName").toString(),
                RoleEnum.valueOf(decodedJWT.getClaim("role").asString())
        );
    }

    private String generateAccessToken(UserInfoDTO user, Date expirationAt) {

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("email", user.getEmail())
                .withClaim("userId", user.getUserId())
                .withClaim("firstName", user.getName())
                .withClaim("companyId", user.getCompanyId())
                .withClaim("companyName", user.getCompanyName())
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
