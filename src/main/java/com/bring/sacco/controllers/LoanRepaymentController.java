package com.bring.sacco.controllers;

import com.bring.sacco.entities.LoanApplication;
import com.bring.sacco.entities.LoanRepayment;
import com.bring.sacco.services.LoanRepaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loanRepayment")
public class LoanRepaymentController {
    private final LoanRepaymentService loanRepaymentService;


    public LoanRepaymentController(LoanRepaymentService LoanRepaymentService) {
        this.loanRepaymentService = LoanRepaymentService;
    }

    @PostMapping("/create")
    public LoanRepayment createLoanRepayment(@RequestBody LoanRepayment loanRepayment){

        return loanRepaymentService.createLoanRepayment(loanRepayment);
    }

    @PutMapping("/update")
    public LoanRepayment updateLoanRepayment(@RequestBody LoanRepayment dto,
                                             @PathVariable ("id") long loanRepaymentId){

        return loanRepaymentService.updateLoanRepayment(dto,loanRepaymentId);
    }

    @GetMapping("/all")
    public List<LoanRepayment> getAll() {
        return loanRepaymentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        loanRepaymentService.deleteById(id);
    }
}
