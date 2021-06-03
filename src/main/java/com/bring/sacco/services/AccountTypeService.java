package com.bring.sacco.services;


import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.AccountType;
import com.bring.sacco.repositories.AccountTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeService {
    @Autowired
    ModelMapper modelMapper;
    private final AccountTypeRepository accountTypeRepository;


    public AccountTypeService(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository =accountTypeRepository;
    }

    public AccountType createAccountType(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

    public AccountType updateAccountType(AccountType dto, long accountTypeId) {
        AccountType accountType= accountTypeRepository.findById(accountTypeId).get();
        modelMapper.map(dto, accountType);
        accountType.setAccountTypeId(accountTypeId);



        return accountTypeRepository.save(accountType);

    }

    public List<AccountType> getAll(){
        return accountTypeRepository.findAll();
    }

    public void deleteById(long id){ accountTypeRepository.deleteById(id);}




}
