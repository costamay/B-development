package com.bring.sacco.services;

import com.bring.sacco.entities.LoanType;
import com.bring.sacco.entities.TransactionType;
import com.bring.sacco.repositories.TransactionTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {

    @Autowired
    ModelMapper modelMapper;

    private final TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository){

        this.transactionTypeRepository = transactionTypeRepository;
    }

    public TransactionType createTransactionType(TransactionType transactionType){
        return transactionTypeRepository.save(transactionType);
    }

    public TransactionType updateTransactionType(TransactionType dto, long transactionTypeId){
        TransactionType transactionType = transactionTypeRepository.findById(transactionTypeId).get();
        modelMapper.map(dto, transactionType);
        transactionType.setTransactionId(transactionTypeId);


        return transactionTypeRepository.save(transactionType);

    }

    public List<TransactionType> getAll() {
        return transactionTypeRepository.findAll();
    }

    public void deleteById(long id) {
        transactionTypeRepository.deleteById(id);
    }
}

