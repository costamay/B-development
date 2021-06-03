package com.bring.sacco.controllers;

import com.bring.sacco.entities.Account;
import com.bring.sacco.entities.LoanApplication;
import com.bring.sacco.services.LoanApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loanApplication")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;

    }

    @PostMapping("/create")
    public LoanApplication createLoanApplication(@RequestBody LoanApplication loanApplication){
        return loanApplicationService.createLoanApplication(loanApplication);

    }

    @PutMapping("/update")
    public LoanApplication updateLoanApplication(@RequestBody LoanApplication dto, @PathVariable ("id") long loanApplicationId) {
        return loanApplicationService.updateLoanApplication(dto,loanApplicationId);

    }

    @GetMapping("/all")
    public List<LoanApplication> getAll() {
        return loanApplicationService.getAll();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        loanApplicationService.deleteById(id);
    }
}
