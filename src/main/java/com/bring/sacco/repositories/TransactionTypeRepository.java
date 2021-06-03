package com.bring.sacco.repositories;

import com.bring.sacco.entities.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {

}

