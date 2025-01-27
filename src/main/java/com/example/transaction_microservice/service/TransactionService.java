package com.example.transaction_microservice.service;

import com.example.transaction_microservice.entity.TransactionEntity;
import com.example.transaction_microservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Create a new transaction
    public TransactionEntity createTransaction(TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get transaction by ID
    public Optional<TransactionEntity> getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    // Update transaction
    public TransactionEntity updateTransaction(Long transactionId, TransactionEntity updatedTransaction) {
        updatedTransaction.setTransactionId(transactionId);
        return transactionRepository.save(updatedTransaction);
    }

    // Delete transaction
    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}