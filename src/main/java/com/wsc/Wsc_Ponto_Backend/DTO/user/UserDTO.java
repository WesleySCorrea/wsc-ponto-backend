package com.wsc.Wsc_Ponto_Backend.DTO.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wsc.Wsc_Ponto_Backend.DTO.company.CompanyDTO;
import com.wsc.Wsc_Ponto_Backend.entity.User;
import com.wsc.Wsc_Ponto_Backend.enuns.RoleEnum;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updatedAt;
    private Boolean active;
    private RoleEnum role;
    private CompanyDTO company;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.active = user.getActive();
        this.role = user.getRole();
        this.company = new CompanyDTO(user.getCompany());
    }
}
