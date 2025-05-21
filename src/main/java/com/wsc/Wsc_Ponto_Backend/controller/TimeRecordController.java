package com.wsc.Wsc_Ponto_Backend.controller;

import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.request.TimeRecordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response.DailyTimeRecordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response.TimeRecordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.service.TimeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/time-record")
public class TimeRecordController {

    private final TimeRecordService timeRecordService;

    @PostMapping
    public ResponseEntity<TimeRecordResponseDTO> timeRecord(@RequestBody TimeRecordRequestDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(timeRecordService.timeRecord(request));
    }

    @GetMapping("/daily-time-records")
    public ResponseEntity<List<DailyTimeRecordResponseDTO>> getDailyTimeRecord (
            @RequestParam String startDate,
            @RequestParam String endDate) {

        List<DailyTimeRecordResponseDTO> records = timeRecordService.getDailyTimeRecord(startDate,endDate);

        return ResponseEntity.ok().body(records);
    }
}
