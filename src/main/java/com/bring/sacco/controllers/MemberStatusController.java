package com.bring.sacco.controllers;


import com.bring.sacco.entities.AccountStatus;
import com.bring.sacco.entities.LoanStatus;
import com.bring.sacco.entities.MemberStatus;
import com.bring.sacco.services.AccountStatusService;
import com.bring.sacco.services.MemberStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("memberStatus")
public class MemberStatusController {

    private final MemberStatusService memberStatusService;

    public MemberStatusController(MemberStatusService memberStatusService){
        this.memberStatusService = memberStatusService;
    }

    @PostMapping("/create")
    public MemberStatus createMemberStatus(@RequestBody MemberStatus memberStatus) {
        return memberStatusService.createMemberStatus(memberStatus);
    }

    @PutMapping("/update/{id}")
    public MemberStatus updateMemberStatus(@RequestBody MemberStatus dto,
                                       @PathVariable ("id") long memberStatusId) {
        return memberStatusService.updateMemberStatus(dto,memberStatusId);
    }

    @GetMapping("/all")
    public List<MemberStatus> getAll() {
        return memberStatusService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        memberStatusService.deleteById(id);
    }
}
