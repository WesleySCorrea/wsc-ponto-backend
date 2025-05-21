package com.wsc.Wsc_Ponto_Backend.controller;

import com.wsc.Wsc_Ponto_Backend.DTO.workSchedule.request.WorkScheduleRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.workSchedule.response.WorkScheduleResponseDTO;
import com.wsc.Wsc_Ponto_Backend.service.WorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/work-schedule")
public class WorkScheduleController {

    private final WorkScheduleService workScheduleService;

    @PostMapping
    public ResponseEntity<WorkScheduleResponseDTO> salvar(@RequestBody WorkScheduleRequestDTO request) {

        return ResponseEntity.ok().body(workScheduleService.save(request));
    }
}
