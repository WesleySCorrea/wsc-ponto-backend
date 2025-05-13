package com.wsc.Wsc_Ponto_Backend.DTO.company.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wsc.Wsc_Ponto_Backend.entity.Company;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyResponseDTO {

    private Long id;
    private String companyName;
    private String cnpj;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updatedAt;
    private Boolean active;

    public CompanyResponseDTO(Company company) {
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.cnpj = company.getCnpj();
        this.createdAt = company.getCreatedAt();
        this.updatedAt = company.getUpdatedAt();
        this.active = company.getActive();
    }
}
