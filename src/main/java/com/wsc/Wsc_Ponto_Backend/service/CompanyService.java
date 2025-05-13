package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.company.request.CompanyRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.company.response.CompanyResponseDTO;

public interface CompanyService {

    CompanyResponseDTO save(CompanyRequestDTO request);
}
