package com.wsc.Wsc_Ponto_Backend.repository;

import com.wsc.Wsc_Ponto_Backend.entity.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {

    Double countByUserIdAndDate(Long userId, LocalDate date);
}
