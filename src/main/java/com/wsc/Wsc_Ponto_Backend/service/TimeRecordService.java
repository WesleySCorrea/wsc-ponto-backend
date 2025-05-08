package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.request.TimeRecordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.response.TimeRecordResponseDTO;

public interface TimeRecordService {

    TimeRecordResponseDTO registerTimeRecord(TimeRecordRequestDTO request);
}
