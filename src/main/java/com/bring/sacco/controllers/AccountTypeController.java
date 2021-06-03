package com.bring.sacco.controllers;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.AccountType;
import com.bring.sacco.repositories.AccountTypeRepository;
import com.bring.sacco.services.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accountType")
public class AccountTypeController {

    private final AccountTypeService accountTypeService;
    public AccountTypeController(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;

    }

    @PostMapping("/create")
    public AccountType createAccountType(@RequestBody AccountType accountType){
        return accountTypeService.createAccountType(accountType);
    }

    @PutMapping("/update/{id}")
    public AccountType updateAccountType(@RequestBody AccountType dto, @PathVariable ("id") long accountTypeId){
        return accountTypeService.updateAccountType(dto, accountTypeId);

    }

    @GetMapping("/all")
    public List<AccountType> getAll() {
        return accountTypeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        accountTypeService.deleteById(id);
    }


}
