package com.bring.sacco.services;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.Member;
import com.bring.sacco.exception_handlers.ResourceNotFoundException;
import com.bring.sacco.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService {
    //Model mapping autowired
    @Autowired
    ModelMapper modelMapper;

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMemberById(Member dto, long memberId){
        if (!memberRepository.findById(memberId).isPresent()){
            throw new ResourceNotFoundException("Member does not exist so update impossible");

        }
        //We use model mapping instead of .set() method to be able to update single values instead of the whole object
        Member member= memberRepository.findById(memberId).get(); // we use .get() to avoid optional
        member.setMemberId(memberId);
        modelMapper.map(dto, member);


        return memberRepository.save(member);

    }

    public List<Member> getAll(){
        return memberRepository.findAll();
    }


    public void deleteById(long id) {
        memberRepository.deleteById(id);
    }


}
