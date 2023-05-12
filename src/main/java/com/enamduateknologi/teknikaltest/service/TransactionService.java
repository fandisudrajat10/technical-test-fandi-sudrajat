package com.enamduateknologi.teknikaltest.service;

import java.util.List;

public interface TransactionService {

    void saveTransaction(List<String> transactionTypeList, String businessId);

    List<String> getAllTransactionTypeByBusinessId(String businessId);

    void deleteByBusinessId(String businessId);
}
