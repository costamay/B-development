package com.bring.sacco.repositories;

import com.bring.sacco.entities.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanStatusRepository extends JpaRepository<LoanStatus, Long> {

}