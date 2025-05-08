package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.request.TimeRecordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.response.TimeRecordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.entity.TimeRecord;
import com.wsc.Wsc_Ponto_Backend.enuns.TypeEnum;
import com.wsc.Wsc_Ponto_Backend.repository.TimeRecordRepository;
import com.wsc.Wsc_Ponto_Backend.service.TimeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TimeRecordServiceImpl implements TimeRecordService {

    private final TimeRecordRepository repository;

    @Override
    public TimeRecordResponseDTO registerTimeRecord(TimeRecordRequestDTO request) {

        TypeEnum typeEnum = this.getRecordType(request.getUserId());

        TimeRecord record = request.toEntity(request, typeEnum);

        record = repository.save(record);

        return new TimeRecordResponseDTO(record);
    }

    private TypeEnum getRecordType(Long userId) {

        Double recordsToday  = repository.countByUserIdAndDate(userId, LocalDate.now());
        if (recordsToday  % 2 != 0 ) {
            return TypeEnum.EXIT;
        }
        return TypeEnum.ENTRY;
    }
}
