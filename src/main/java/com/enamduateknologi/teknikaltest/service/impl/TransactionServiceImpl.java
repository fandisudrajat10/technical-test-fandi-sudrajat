package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.domain.Transaction;
import com.enamduateknologi.teknikaltest.repository.TransactionRepository;
import com.enamduateknologi.teknikaltest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public void saveTransaction(List<String> transactionTypeList, String businessId) {
        deleteByBusinessId(businessId);
        for (String transactionType : transactionTypeList){
            Business business = new Business();
            business.setId(businessId);
            Transaction transaction = new Transaction();
            transaction.setTransactionType(transactionType);
            transaction.setBusiness(business);
            transactionRepository.save(transaction);
        }
    }

    @Override
    public List<String> getAllTransactionTypeByBusinessId(String businessId) {
        List<Transaction> transactionList = transactionRepository.findAllByBusinessId(businessId);
        List<String> transactions = new ArrayList<>();
        for (Transaction transaction : transactionList){
            transactions.add(transaction.getTransactionType());
        }
        return transactions;
    }

    @Override
    public void deleteByBusinessId(String businessId) {
        List<Transaction> transactionList = transactionRepository.findAllByBusinessId(businessId);
        for (Transaction transaction : transactionList){
            transactionRepository.delete(transaction);
        }
    }
}
