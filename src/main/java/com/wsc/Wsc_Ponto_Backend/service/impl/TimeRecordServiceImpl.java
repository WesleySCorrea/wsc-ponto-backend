package com.wsc.Wsc_Ponto_Backend.service.impl;

import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.request.TimeRecordRequestDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response.DailyTimeRecordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.timeRecord.response.TimeRecordResponseDTO;
import com.wsc.Wsc_Ponto_Backend.DTO.user.UserInfoDTO;
import com.wsc.Wsc_Ponto_Backend.entity.TimeRecord;
import com.wsc.Wsc_Ponto_Backend.enuns.TypeEnum;
import com.wsc.Wsc_Ponto_Backend.repository.TimeRecordRepository;
import com.wsc.Wsc_Ponto_Backend.service.TimeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.wsc.Wsc_Ponto_Backend.service.impl.AuthServiceImpl.getUserInfoDTO;

@Service
@RequiredArgsConstructor
public class TimeRecordServiceImpl implements TimeRecordService {

    private final TimeRecordRepository repository;

    @Override
    public TimeRecordResponseDTO timeRecord(TimeRecordRequestDTO request) {

        UserInfoDTO userInfo = getUserInfoDTO();

        TypeEnum typeEnum = this.getRecordType(userInfo.getUserId());

        TimeRecord record = request.toEntity(request, typeEnum, userInfo.getUserId());

        record = repository.save(record);

        return new TimeRecordResponseDTO(record);
    }

    @Override
    public List<DailyTimeRecordResponseDTO> getDailyTimeRecord(String startDate, String endDate) {

        UserInfoDTO userInfo = getUserInfoDTO();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        List<TimeRecord> records = repository.findByUser_IdAndDateBetween(
                userInfo.getUserId(),
                start,
                end
        );

        Map<LocalDate, List<LocalTime>> grouped = this.groupRecordsGyDate(records);

        Map<LocalDate, List<LocalTime>> fullMap = this.fillMissingDates(start, end, grouped);

        return fullMap.entrySet().stream()
                .map(entry -> new DailyTimeRecordResponseDTO(
                        entry.getKey(),
                        entry.getValue()
                ))
                .toList();
    }

    private TypeEnum getRecordType(Long userId) {

        Double recordsToday  = repository.countByUserIdAndDate(userId, LocalDate.now());
        if (recordsToday  % 2 != 0 ) {
            return TypeEnum.EXIT;
        }
        return TypeEnum.ENTRY;
    }

    private Map<LocalDate, List<LocalTime>> groupRecordsGyDate (List<TimeRecord> records) {

        //Ordena a lista por data.
        records.sort(Comparator.comparing((TimeRecord::getDate)));

        //Coloca em um Map por data
        Map<LocalDate, List<LocalTime>> recordsByDate = new LinkedHashMap<>();

        for (TimeRecord record : records) {
            recordsByDate.computeIfAbsent(record.getDate(), k -> new ArrayList<>())
                    .add(record.getTime());
        }

        recordsByDate.forEach((date, time) -> {
            time.sort(LocalTime::compareTo);
        });
        return recordsByDate;
    }

    private Map<LocalDate, List<LocalTime>> fillMissingDates(LocalDate start, LocalDate end, Map<LocalDate, List<LocalTime>> originalMap) {
        Map<LocalDate, List<LocalTime>> completeMap = new LinkedHashMap<>();
        LocalDate currentDate = start;

        while (!currentDate.isAfter(end)) {
            completeMap.put(currentDate, originalMap.getOrDefault(currentDate, new ArrayList<>()));
            currentDate = currentDate.plusDays(1);
        }

        return completeMap;
    }
}
