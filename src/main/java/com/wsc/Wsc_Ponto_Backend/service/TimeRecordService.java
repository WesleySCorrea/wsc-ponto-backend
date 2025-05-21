package com.wsc.Wsc_Ponto_Backend.service;

import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.request.TimeRecordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response.DailyTimeRecordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response.TimeRecordResponseDTO;

import java.util.List;

public interface TimeRecordService {

    TimeRecordResponseDTO timeRecord(TimeRecordRequestDTO request);
    List<DailyTimeRecordResponseDTO> getDailyTimeRecord (String startDate, String endDate);
}
