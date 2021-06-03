package com.bring.sacco.repositories;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.Member;
import com.bring.sacco.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}