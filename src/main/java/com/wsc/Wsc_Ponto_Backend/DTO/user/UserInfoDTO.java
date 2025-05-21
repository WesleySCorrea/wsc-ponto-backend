package com.wsc.Wsc_Ponto_Backend.DTO.user;

import com.wsc.Wsc_Ponto_Backend.enuns.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoDTO {

    private Long userId;
    private String name;
    private String email;
    private Long companyId;
    private String companyName;
    private RoleEnum role;

    public UserInfoDTO (UserDTO user) {
        this.userId = user.getId();
        this.name = user.getFirstName();
        this.email = user.getEmail();
        this.companyId = user.getCompany().getId();
        this.companyName = user.getCompany().getCompanyName();
        this.role = user.getRole();
    }
}
