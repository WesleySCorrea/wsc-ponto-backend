package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.company.request.CompanyRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.company.response.CompanyResponseDTO;
import com.wsc.Wsc_Ponto_Backend.entity.Company;
import com.wsc.Wsc_Ponto_Backend.repository.CompanyRepository;
import com.wsc.Wsc_Ponto_Backend.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public CompanyResponseDTO save(CompanyRequestDTO request) {

        Company company = request.toEntity(request);

        company = repository.save(company);

        return new CompanyResponseDTO(company);
    }
}
