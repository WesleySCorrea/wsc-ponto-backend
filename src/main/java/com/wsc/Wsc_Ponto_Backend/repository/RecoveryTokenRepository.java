package com.wsc.Wsc_Ponto_Backend.repository;

import com.wsc.Wsc_Ponto_Backend.entity.RecoveryToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryTokenRepository extends JpaRepository<RecoveryToken, Long> {
}
