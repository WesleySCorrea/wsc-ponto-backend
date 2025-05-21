package com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wsc.Wsc_Ponto_Backend.entity.TimeRecord;
import com.wsc.Wsc_Ponto_Backend.enuns.OriginEnum;
import com.wsc.Wsc_Ponto_Backend.enuns.TypeEnum;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeRecordResponseDTO {

    private String status;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalTime time;
    private TypeEnum type;
    private OriginEnum origin;
    private Double latitude;
    private Double longitude;
    private String user;

    public TimeRecordResponseDTO(TimeRecord record) {
        this.status = "Ponto Registrado com Sucesso";
        this.date = record.getDate();
        this.time = record.getTime();
        this.type = record.getType();
        this.latitude = record.getLatitude();
        this.longitude = record.getLongitude();
        this.origin = record.getOrigin();

        this.user = "Wesley";//record.getUsuario().getNome();
    }
}
