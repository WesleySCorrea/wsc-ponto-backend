package com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
public class DailyTimeRecordResponseDTO {

    @JsonFormat(pattern = "dd/MM/yy", timezone = "America/Sao_Paulo")
    private LocalDate date;
    private String dayOfWeek;
    @JsonFormat(pattern = "HH:mm")
    private List<LocalTime> schedules;

    public DailyTimeRecordResponseDTO(LocalDate date, List<LocalTime> times) {
        this.date = date;
        this.dayOfWeek = this.getDayOfWeekInPortuguese(date);
        this.schedules = times;
    }

    private String getDayOfWeekInPortuguese (LocalDate date)  {
        return switch (date.getDayOfWeek()) {
            case MONDAY -> "Segunda";
            case TUESDAY -> "Terça";
            case WEDNESDAY -> "Quarta";
            case THURSDAY -> "Quinta";
            case FRIDAY -> "Sexta";
            case SATURDAY -> "Sábado";
            case SUNDAY -> "Domingo";
        };
    }
}
