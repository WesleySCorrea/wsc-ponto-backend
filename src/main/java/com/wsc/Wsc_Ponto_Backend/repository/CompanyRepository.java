package com.wsc.Wsc_Ponto_Backend.repository;

import com.wsc.Wsc_Ponto_Backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
