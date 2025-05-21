package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.workSchedule.request.WorkScheduleRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.workSchedule.response.WorkScheduleResponseDTO;

public interface WorkScheduleService {

    WorkScheduleResponseDTO save(WorkScheduleRequestDTO request);
}
