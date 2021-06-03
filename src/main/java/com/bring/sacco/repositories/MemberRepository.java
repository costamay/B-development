package com.bring.sacco.repositories;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

}

