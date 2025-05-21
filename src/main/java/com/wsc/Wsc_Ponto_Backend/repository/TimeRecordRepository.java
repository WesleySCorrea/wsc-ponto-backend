package com.wsc.Wsc_Ponto_Backend.repository;

import com.wsc.Wsc_Ponto_Backend.entity.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {

    Double countByUserIdAndDate(Long userId, LocalDate date);
    List<TimeRecord> findByUser_IdAndDateBetween(Long userId, LocalDate start, LocalDate end);

}
