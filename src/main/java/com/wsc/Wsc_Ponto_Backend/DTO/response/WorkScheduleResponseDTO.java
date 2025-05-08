package com.wsc.Wsc_Ponto_Backend.DTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wsc.Wsc_Ponto_Backend.entity.WorkSchedule;
import com.wsc.Wsc_Ponto_Backend.entity.User;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkScheduleResponseDTO {

    private Long id;
    private String name;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalTime stardTime;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalTime endTime;
    private int entryTolerance;
    private int exitTolerance;
    private String breakDuration;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime updatedAt;
    private CompanyResponseDTO company;
    private User createdBy;

    public WorkScheduleResponseDTO(WorkSchedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.stardTime = schedule.getEntryTime();
        this.endTime = schedule.getEndTime();
        this.entryTolerance = schedule.getEntryTolerance();
        this.exitTolerance = schedule.getExitTolerance();
        this.breakDuration = formatDuration(schedule.getBreakDuration());
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
        this.company = new CompanyResponseDTO(schedule.getCompany());
        this.createdBy = schedule.getCreatedBy();
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return String.format("%d:%02d:00", hours, minutes);
    }
}
