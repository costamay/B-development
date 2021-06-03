package com.bring.sacco.repositories;

import com.bring.sacco.entities.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Long> {
}
