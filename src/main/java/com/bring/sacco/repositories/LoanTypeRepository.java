package com.bring.sacco.repositories;

import com.bring.sacco.entities.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanTypeRepository extends JpaRepository<LoanType, Long> {


}