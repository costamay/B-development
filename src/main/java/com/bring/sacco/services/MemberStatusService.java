package com.bring.sacco.services;

import com.bring.sacco.entities.AccountStatus;
import com.bring.sacco.entities.Member;
import com.bring.sacco.entities.MemberStatus;
import com.bring.sacco.exception_handlers.ResourceNotFoundException;
import com.bring.sacco.repositories.MemberStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberStatusService {

    @Autowired
    ModelMapper modelMapper;
    private final MemberStatusRepository memberStatusRepository;
    public MemberStatusService(MemberStatusRepository memberStatusRepository){
        this.memberStatusRepository = memberStatusRepository;
    }

    public MemberStatus createMemberStatus(MemberStatus memberStatus) {

        return memberStatusRepository.save(memberStatus);
    }

    public MemberStatus updateMemberStatus(MemberStatus dto, long memberStatusId) {

        if (!memberStatusRepository.findById(memberStatusId).isPresent()){
            throw new ResourceNotFoundException("Member Status does not exist so update impossible");

        }
        MemberStatus memberStatus= memberStatusRepository.findById(memberStatusId).get();

        modelMapper.map(dto, memberStatus);

        memberStatus.setMemberStatusId(memberStatusId);

        return memberStatusRepository.save(memberStatus);
    }

    public List<MemberStatus> getAll() {
        return memberStatusRepository.findAll();
    }

    public void deleteById(long id) {
        memberStatusRepository.deleteById(id);
    }
}
