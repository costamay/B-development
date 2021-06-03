package com.bring.sacco.controllers;




import com.bring.sacco.entities.Transaction;
import com.bring.sacco.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }


    @PostMapping("/create")
    public Transaction createTransaction(@RequestBody Transaction transaction){

        return transactionService.createTransaction(transaction);

    }

    @PutMapping("/update/{id}")
    public Transaction updateTransaction(@RequestBody Transaction dto, @PathVariable ("id") long transactionId) {
        return transactionService.updateTransaction(dto,transactionId);

    }

    @GetMapping("/all")
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        transactionService.deleteById(id);
    }


}

