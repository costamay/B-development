package com.bring.sacco.repositories;

import com.bring.sacco.entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

}