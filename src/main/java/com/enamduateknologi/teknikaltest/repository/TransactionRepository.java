package com.enamduateknologi.teknikaltest.repository;

import com.enamduateknologi.teknikaltest.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findAllByBusinessId(String businessId);

    void deleteAllByBusinessId(String businessId);
}
