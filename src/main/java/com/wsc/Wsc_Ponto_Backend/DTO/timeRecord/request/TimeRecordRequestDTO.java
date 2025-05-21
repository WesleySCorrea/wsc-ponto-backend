package com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.request;

import com.wsc.Wsc_Ponto_Backend.entity.TimeRecord;
import com.wsc.Wsc_Ponto_Backend.entity.User;
import com.wsc.Wsc_Ponto_Backend.enuns.OriginEnum;
import com.wsc.Wsc_Ponto_Backend.enuns.TypeEnum;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class TimeRecordRequestDTO {

    private Double latitude;
    private Double longitude;

    public TimeRecord toEntity (TimeRecordRequestDTO request, TypeEnum type, Long userId) {
        TimeRecord record = new TimeRecord();
        record.setDate(LocalDate.now());
        record.setTime(LocalTime.now());
        record.setType(type);
        record.setOrigin(OriginEnum.WEB);
        record.setLatitude(request.getLatitude());
        record.setLongitude(request.getLongitude());

        User user = new User();
        user.setId(userId);
        record.setUser(user);

        return record;
    }
}
