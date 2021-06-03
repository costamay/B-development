package com.bring.sacco.services;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.AccountStatus;
import com.bring.sacco.entities.LoanStatus;
import com.bring.sacco.repositories.AccountStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatusService {

    @Autowired
    ModelMapper modelMapper;

    private final AccountStatusRepository accountStatusRepository;
    public AccountStatusService(AccountStatusRepository accountStatusRepository){
        this.accountStatusRepository = accountStatusRepository;
    }


    public AccountStatus createAccountStatus(AccountStatus accountStatus) {

        return accountStatusRepository.save(accountStatus);
    }

    public AccountStatus updateAccountStatus(AccountStatus dto, long accountStatusId) {

        AccountStatus accountStatus= accountStatusRepository.findById(accountStatusId).get();
        modelMapper.map(dto, accountStatus);
        accountStatus.setAccountStatusId(accountStatusId);


        return accountStatusRepository.save(accountStatus);
    }

    public List<AccountStatus> getAll() {
        return accountStatusRepository.findAll();
    }

    public void deleteById(long id) {
        accountStatusRepository.deleteById(id);
    }

}
