package com.wsc.Wsc_Ponto_Backend.DTO.request;

import com.wsc.Wsc_Ponto_Backend.entity.Company;
import com.wsc.Wsc_Ponto_Backend.entity.WorkSchedule;
import com.wsc.Wsc_Ponto_Backend.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDTO {

    @NotBlank(message = "First name is required")
    @Size(min = 5, max = 25, message = "First name must be between 5 and 25 characters")
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Size(min = 5, max = 50, message = "Last name must be between 5 and 50 characters")
    private String lastName;
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 16, message = "Password must be between 6 and 16 characters")
    private String password;
    @NotNull(message = "Company ID is required")
    private Long companyId;

    @NotNull(message = "Work schedule ID is required")
    private Long workScheduleId;

    public User toEntity (UserRequestDTO request) {
        User user = new User();
        user.setFirstName(request.firstName);
        user.setLastName(request.lastName);
        user.setEmail(request.email);
        user.setPassword(request.password);

        Company company = new Company();
        company.setId(request.companyId);
        user.setCompany(company);

        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setId(request.workScheduleId);
        user.setWorkSchedule(workSchedule);

        return user;
    }
}
