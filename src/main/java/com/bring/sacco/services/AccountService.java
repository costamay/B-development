package com.bring.sacco.services;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.Member;
import com.bring.sacco.exception_handlers.ResourceNotFoundException;
import com.bring.sacco.repositories.AccountRepository;
import com.bring.sacco.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;



    public Account createAccount(Account account){

        Member member = memberRepository.findById(account.getMemberId()).orElse(null);
        if (member == null){
            throw new ResourceNotFoundException("Member not found");

        }
//        account.setSqlTimestamp(new Date());

        return accountRepository.save(account);


    }

    public Account updateAccount(Account  dto,long accountId){
        Account account= accountRepository.findById(accountId).get();
        modelMapper.map(dto, account);
        account.setAccountId(accountId);
        return accountRepository.save(account);

    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    public Optional<Account> getAccountById(long accountId) {
        return accountRepository.findById(accountId);
    }

    public Optional<Account> getAccountByAccountNumber(long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }


    public void deleteById(long id) {
        accountRepository.deleteById(id);
    }


}
