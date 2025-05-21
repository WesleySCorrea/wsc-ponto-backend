package com.wsc.Wsc_Ponto_Backend.config;

import com.wsc.Wsc_Ponto_Backend.DTO.user.UserInfoDTO;
import com.wsc.Wsc_Ponto_Backend.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getRequestURI().equals("/api/v1/auth/login/refresh") || request.getRequestURI().equals("/api/v1/auth/login")
                || request.getRequestURI().equals("/api/v1/auth/recovery-password") || request.getRequestURI().equals("/api/v1/company")
                || request.getRequestURI().equals("/api/v1/work-schedule")
                || request.getRequestURI().equals("/api/v1/user") || request.getRequestURI().equals("/api/v1/company")) {

            filterChain.doFilter(request, response);
            return;
        }


        String token = this.getTokenFromRequest(request);


            UserInfoDTO userInfoDTO = jwtService.validateTokenAndExtractUserInfo(token);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userInfoDTO.getName(),
                            null,
                            List.of(new SimpleGrantedAuthority("ROLE_" + userInfoDTO.getRole().name()))
                    );
            authentication.setDetails(userInfoDTO);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest (HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
//        throw new PersistFailedException("Token not found");
        throw new RuntimeException("Token not found");
    }
}
