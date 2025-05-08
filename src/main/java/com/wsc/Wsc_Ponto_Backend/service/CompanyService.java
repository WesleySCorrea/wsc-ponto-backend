package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.request.CompanyRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.response.CompanyResponseDTO;

public interface CompanyService {

    CompanyResponseDTO save(CompanyRequestDTO request);
}
