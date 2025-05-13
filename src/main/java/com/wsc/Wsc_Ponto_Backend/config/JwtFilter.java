package com.wsc.Wsc_Ponto_Backend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
//    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getRequestURI().equals("/api/v1/login/refresh") || request.getRequestURI().equals("/api/v1/login")
                || request.getRequestURI().equals("/api/v1/user") || request.getRequestURI().equals("/api/v1/company")
                || request.getRequestURI().equals("/api/v1/user") || request.getRequestURI().equals("/api/v1/company")) {

            filterChain.doFilter(request, response);
            return;
        }


        String token = this.getTokenFromRequest(request);


//            UserInfoDTO userInfoDTO = tokenService.validateTokenAndExtractUserInfo(token);
//
//            UsernamePasswordAuthenticationToken authentication =
//                    new UsernamePasswordAuthenticationToken(
//                            userInfoDTO.getUsername(),
//                            null,
//                            List.of(new SimpleGrantedAuthority("ROLE_" + userInfoDTO.getRole().name()))
//                    );
//            authentication.setDetails(userInfoDTO);
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
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
