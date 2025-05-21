package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.workSchedule.request.WorkScheduleRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.workSchedule.response.WorkScheduleResponseDTO;
import com.wsc.Wsc_Ponto_Backend.entity.WorkSchedule;
import com.wsc.Wsc_Ponto_Backend.repository.WorkScheduleRepository;
import com.wsc.Wsc_Ponto_Backend.service.WorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkScheduleServiceImpl implements WorkScheduleService {

    private final WorkScheduleRepository repository;

    @Override
    public WorkScheduleResponseDTO save(WorkScheduleRequestDTO request) {

        WorkSchedule schedule = request.toEntity(request);

        schedule = repository.save(schedule);

        return new WorkScheduleResponseDTO(schedule);
    }
}
