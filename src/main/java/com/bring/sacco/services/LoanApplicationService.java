package com.bring.sacco.services;


import com.bring.sacco.entities.*;
import com.bring.sacco.exception_handlers.ResourceNotFoundException;
import com.bring.sacco.repositories.AccountRepository;
import com.bring.sacco.repositories.LoanApplicationRepository;
import com.bring.sacco.repositories.LoanStatusRepository;
import com.bring.sacco.repositories.LoanTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanApplicationService {
    @Autowired
    ModelMapper modelMapper;

    private final LoanApplicationRepository loanApplicationRepository;
    private final LoanTypeRepository loanTypeRepository;
    private final AccountRepository accountRepository;
    private final LoanStatusRepository loanStatusRepository;

    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository,
                                  LoanTypeRepository loanTypeRepository, AccountRepository accountRepository,
                                  LoanStatusRepository loanStatusRepository){
        this.loanApplicationRepository = loanApplicationRepository;
        this.loanTypeRepository = loanTypeRepository;
        this.accountRepository = accountRepository;
        this.loanStatusRepository = loanStatusRepository;

    }

    public LoanApplication createLoanApplication(LoanApplication loanApplication){

        // We need to carry out checks before we can persist data (Add checks for all the POST APIs   )

        Optional<LoanType> loanType = loanTypeRepository.findById(loanApplication.getLoanTypeId());
        if (!loanTypeRepository.findById(loanApplication.getLoanTypeId()).isPresent())
        {
            throw new ResourceNotFoundException("LoanType ID Does not exist");

        }


        Optional<Account> account = accountRepository.findById(loanApplication.getAccountId());
        if (!accountRepository.findById(loanApplication.getAccountId()).isPresent()) {

            throw new ResourceNotFoundException("Account ID Does not exist");
        }

        Optional<LoanStatus> loanStatus = loanStatusRepository.findById(loanApplication.getLoanStatusId());
        if (!loanStatusRepository.findById(loanApplication.getLoanStatusId()).isPresent()) {

            throw new ResourceNotFoundException("Loan Status ID Does not exist");
        }


        return loanApplicationRepository.save(loanApplication);
    }


    public LoanApplication updateLoanApplication(LoanApplication  dto,long loanApplicationId){
        if (!loanApplicationRepository.findById(loanApplicationId).isPresent()){
            throw new ResourceNotFoundException("Loan Application Id does not exist so update impossible");
        }
        LoanApplication loanApplication= loanApplicationRepository.findById(loanApplicationId).get();
        modelMapper.map(dto, loanApplication);
        loanApplication.setLoanApplicationId(loanApplicationId);

        return loanApplicationRepository.save(loanApplication);


    }

    public List<LoanApplication> getAll() {
        return loanApplicationRepository.findAll();
    }

    public void deleteById(long id) {
        loanApplicationRepository.deleteById(id);
    }


}
