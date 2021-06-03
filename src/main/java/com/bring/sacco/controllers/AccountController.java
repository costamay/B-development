package com.bring.sacco.controllers;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.ShareCapital;
import com.bring.sacco.repositories.AccountRepository;
import com.bring.sacco.entities.Member;
import com.bring.sacco.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @PutMapping("/update/{id}")
    public Account updateAccount(@RequestBody Account dto, @PathVariable ("id") long accountId){
        return accountService.updateAccount(dto, accountId);

    }

    @GetMapping("/all")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Account fetchAccountById(@PathVariable("id") long accountId){

        return accountService.getAccountById(accountId).get();

    }

    @GetMapping("/{accountNumber}")
    public Account fetchAccountByAccountNumber(@PathVariable("accountNumber") long accountNumber){

        return accountService.getAccountById(accountNumber).get();

    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        accountService.deleteById(id);
    }

}
