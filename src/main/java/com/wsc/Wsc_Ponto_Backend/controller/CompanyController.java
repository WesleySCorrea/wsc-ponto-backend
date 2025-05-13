package com.wsc.Wsc_Ponto_Backend.controller;

import com.wsc.Wsc_Ponto_Backend.DTO.company.request.CompanyRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.company.response.CompanyResponseDTO;
import com.wsc.Wsc_Ponto_Backend.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> save(@RequestBody @Valid CompanyRequestDTO request) {

        return ResponseEntity.ok().body(companyService.save(request));
    }
}
