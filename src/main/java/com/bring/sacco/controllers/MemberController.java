package com.bring.sacco.controllers;

import com.bring.sacco.entities.Member;
import com.bring.sacco.headers.Header;
import com.bring.sacco.repositories.MemberRepository;
import com.bring.sacco.responses.MemberResponse;
import com.bring.sacco.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/create")
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping("/all")
    public List<Member> getAll() {
        return memberService.getAll();
    }

//    @GetMapping("find/{id}")
//    public Optional<Member> getMemberById(@PathVariable ("id") long memberId) {
//        return memberRepository.findById(memberId);
//    }
    @GetMapping("memberresponse/{id}")
    public MemberResponse getMemberById(@PathVariable ("id") long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        Header header = new Header(2,"Failure", LocalDateTime.now());

        if (member != null) {
            header.setStatusCode(1);
            header.setStatusMessage("success");
            return new MemberResponse(header,member);
        }

        return new MemberResponse(header,null);
    }

    @PutMapping("/update/{id}")
    public Member updateMember(@RequestBody Member dto, @PathVariable ("id") long memberId){
        return memberService.updateMemberById(dto, memberId); // we use dto because of model mapping, getting the object from the repository to update.

    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        memberService.deleteById(id);
    }
}
