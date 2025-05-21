package com.wsc.Wsc_Ponto_Backend.DTO.workSchedule.request;

import com.wsc.Wsc_Ponto_Backend.entity.Company;
import com.wsc.Wsc_Ponto_Backend.entity.WorkSchedule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalTime;

@Getter
public class WorkScheduleRequestDTO {

    @NotBlank(message = "Work schedule name is required")
    @Size(min = 3, max = 25, message = "Work schedule name must be between 3 and 25 characters")
    private String name;
    @NotNull(message = "Start time is required")
    private LocalTime startTime;
    @NotNull(message = "End time is required")
    private LocalTime endTime;
    @NotNull(message = "Entry tolerance is required")
    private int entryTolerance;
    @NotNull(message = "Exit tolerance is required")
    private int exitTolerance;
    @NotNull(message = "Break duration is required")
    private Duration breakDuration;
    @NotNull(message = "Company ID is required")
    private Long companyId;
    private Long userId;

    public WorkSchedule toEntity (WorkScheduleRequestDTO request) {
        WorkSchedule schedule = new WorkSchedule();
        schedule.setName(request.getName());
        schedule.setEntryTime(request.getStartTime());
        schedule.setEndTime(request.getEndTime());
        schedule.setEntryTolerance(request.entryTolerance);
        schedule.setExitTolerance(request.exitTolerance);
        schedule.setBreakDuration(request.getBreakDuration());

        Company company = new Company();
        company.setId(request.companyId);
        schedule.setCompany(company);

        return schedule;
    }
}
