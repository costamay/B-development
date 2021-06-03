package com.bring.sacco.controllers;

import com.bring.sacco.entities.LoanStatus;
import com.bring.sacco.entities.LoanType;
import com.bring.sacco.services.LoanTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loanType")
public class LoanTypeController {

    private final LoanTypeService loanTypeService;
    public LoanTypeController(LoanTypeService loanTypeService) {
        this.loanTypeService = loanTypeService;

    }

    @PostMapping("/create")
    public LoanType createLoanType(@RequestBody LoanType loanType){
        return loanTypeService.createLoanType(loanType);

    }

    @PutMapping("/update")
    public LoanType updateLoanType(@RequestBody LoanType dto,
                                   @PathVariable ("id") long loanTypeId){
        return loanTypeService.updateLoanType(dto, loanTypeId);

    }

    @GetMapping("/all")
    public List<LoanType> getAll() {
        return loanTypeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        loanTypeService.deleteById(id);
    }
}
