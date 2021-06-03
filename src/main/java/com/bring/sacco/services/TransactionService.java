package com.bring.sacco.services;

import com.bring.sacco.entities.*;
import com.bring.sacco.exception_handlers.ResourceNotFoundException;
import com.bring.sacco.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    ModelMapper modelMapper;

    private final TransactionRepository transactionRepository;
    private final AccountRepository accounRepository;
    private  final MemberRepository memberRepository;
    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              MemberRepository memberRepository,
                              TransactionTypeRepository transactionTypeRepository){
        this.transactionRepository = transactionRepository;
        this.accounRepository = accountRepository;
        this.memberRepository = memberRepository;
        this.transactionTypeRepository = transactionTypeRepository;

    }

    public Transaction createTransaction(Transaction transaction){
        // We need to carry out checks before we can persist data (Add checks for all the POST APIs   )
//        Optional<Account> account = accountRepository.findById(transaction.getAccountId());
        Account account = accounRepository.findById(transaction.getAccountId()).orElse(null);
        if (account == null){
            throw new ResourceNotFoundException("Account not found");

        }

        Member member = memberRepository.findById(account.getMemberId()).orElse(null);
        if (member == null){
            throw new ResourceNotFoundException("Member not found");

        }

        TransactionType transactionType = transactionTypeRepository.findById(transaction.getTransactionTypeId()).orElse(null);
        if (transactionType == null){
            throw new ResourceNotFoundException("Transaction Type Id not found");

        }
        return transactionRepository.save(transaction);

    }

    public Transaction updateTransaction(Transaction  dto,long transactionId){
        if (!transactionRepository.findById(transactionId).isPresent()){
            throw new ResourceNotFoundException("Transaction Id does not exist so update impossible");
        }
        Transaction transaction = transactionRepository.findById(transactionId).get();
        modelMapper.map(dto, transaction);
        transaction.setTransactionId(transactionId);

        return transactionRepository.save(transaction);

    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public void deleteById(long id) {
        transactionRepository.deleteById(id);
    }
}
