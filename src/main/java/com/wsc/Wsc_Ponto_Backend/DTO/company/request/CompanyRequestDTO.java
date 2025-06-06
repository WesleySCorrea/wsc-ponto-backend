package com.wsc.Wsc_Ponto_Backend.DTO.company.request;

import com.wsc.Wsc_Ponto_Backend.entity.Company;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CompanyRequestDTO {

    @NotBlank(message = "Company name is required")
    @Size(min = 3, max = 100, message = "Company name must be between 3 and 100 characters")
    private String companyName;

    @NotBlank(message = "CNPJ is required")
    @Pattern(
            regexp = "\\d{14}",
            message = "CNPJ must contain exactly 14 numeric digits"
    )
    private String cnpj;

    public Company toEntity(CompanyRequestDTO request) {
        Company company = new Company();
        company.setCompanyName(request.companyName);
        company.setCnpj(request.cnpj);

        return company;
    }
}
