package com.bring.sacco.controllers;



import com.bring.sacco.entities.AccountStatus;
import com.bring.sacco.entities.LoanStatus;
import com.bring.sacco.services.AccountStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accountStatus")
public class AccountStatusController {

    private final AccountStatusService accountStatusService;

    public AccountStatusController(AccountStatusService accountStatusService){
        this.accountStatusService = accountStatusService;
    }

    @PostMapping("/create")
    public AccountStatus createAccountStatus(@RequestBody AccountStatus accountStatus) {
        return accountStatusService.createAccountStatus(accountStatus);
    }

    @PutMapping("/update/{id}")
    public AccountStatus updateAccountStatus(@RequestBody AccountStatus dto,
                                       @PathVariable ("id") long accountStatusId) {
        return accountStatusService.updateAccountStatus(dto,accountStatusId);
    }

    @GetMapping("/all")
    public List<AccountStatus> getAll() {
        return accountStatusService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        accountStatusService.deleteById(id);
    }


}
