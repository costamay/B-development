package com.bring.sacco.controllers;

import com.bring.sacco.entities.LoanType;
import com.bring.sacco.entities.TransactionType;
import com.bring.sacco.services.TransactionTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactionType")
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService;

    public TransactionTypeController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @PostMapping("/create")
    public TransactionType createTransactionType(@RequestBody TransactionType transactionType){
        return transactionTypeService.createTransactionType(transactionType);

    }

    @PutMapping("/update")
    public TransactionType updateTransactionType(@RequestBody TransactionType dto,
                                                 @PathVariable ("id") long transactionTypeId){
        return transactionTypeService.updateTransactionType(dto, transactionTypeId);



    }

    @GetMapping("/all")
    public List<TransactionType> getAll(){
        return transactionTypeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        transactionTypeService.deleteById(id);
    }


}
