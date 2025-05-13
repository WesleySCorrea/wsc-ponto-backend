package com.wsc.Wsc_Ponto_Backend.DTO.company;

import com.wsc.Wsc_Ponto_Backend.entity.Company;
import lombok.Getter;

@Getter
public class CompanyDTO {
    private Long id;
    private String companyName;

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.companyName = company.getCompanyName();
    }
}
