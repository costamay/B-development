package com.bring.sacco.repositories;

import com.bring.sacco.entities.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberStatusRepository extends JpaRepository<MemberStatus, Long> {
}
