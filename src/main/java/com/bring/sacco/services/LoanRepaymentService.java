package com.bring.sacco.services;

import com.bring.sacco.entities.*;
import com.bring.sacco.exception_handlers.ResourceNotFoundException;
import com.bring.sacco.repositories.LoanApplicationRepository;
import com.bring.sacco.repositories.LoanRepaymentRepository;
import com.bring.sacco.repositories.LoanTypeRepository;
import com.bring.sacco.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanRepaymentService {

    @Autowired
    ModelMapper modelMapper;
    private final LoanRepaymentRepository loanRepaymentRepository;
    private  final MemberRepository memberRepository;
    private final LoanTypeRepository loanTypeRepository;
    private final LoanApplicationRepository loanApplicationRepository;

    public LoanRepaymentService (LoanRepaymentRepository loanRepaymentRepository,
                                 MemberRepository memberRepository,
                                 LoanTypeRepository loanTypeRepository,
                                 LoanApplicationRepository loanApplicationRepository){
        this.loanRepaymentRepository = loanRepaymentRepository;
        this.memberRepository = memberRepository;
        this.loanTypeRepository =loanTypeRepository;
        this.loanApplicationRepository = loanApplicationRepository;

    }

    public LoanRepayment createLoanRepayment(LoanRepayment loanRepayment){
        Optional<Member> member = memberRepository.findById(loanRepayment.getMemberId());
        if (!memberRepository.findById(loanRepayment.getMemberId()).isPresent()) {

            throw new ResourceNotFoundException("Member ID Does not exist");
        }

        Optional<LoanType> loanType = loanTypeRepository.findById(loanRepayment.getLoanTypeId());
        if (!loanTypeRepository.findById(loanRepayment.getLoanTypeId()).isPresent()) {

            throw new ResourceNotFoundException("Loan Type ID Does not exist");
        }

        Optional<LoanApplication> loanApplication = loanApplicationRepository.findById(loanRepayment.getLoanApplicationId());
        if (!loanApplicationRepository.findById(loanRepayment.getLoanApplicationId()).isPresent()) {

            throw new ResourceNotFoundException("Loan Application ID Does not exist");
        }

        return loanRepaymentRepository.save(loanRepayment);
    }


    public LoanRepayment updateLoanRepayment(LoanRepayment dto,long loanRepaymentId){
        if (!loanRepaymentRepository.findById(loanRepaymentId).isPresent()){
            throw new ResourceNotFoundException("Loan Repayment Id does not exist so update impossible");
        }
        LoanRepayment loanRepayment= loanRepaymentRepository.findById(loanRepaymentId).get();
        modelMapper.map(dto, loanRepayment);
        loanRepayment.setLoanRepaymentId(loanRepaymentId);


        return loanRepaymentRepository.save(loanRepayment);

    }

    public List<LoanRepayment> getAll() {
        return loanRepaymentRepository.findAll();
    }

    public void deleteById(long id) {
        loanRepaymentRepository.deleteById(id);
    }
}
