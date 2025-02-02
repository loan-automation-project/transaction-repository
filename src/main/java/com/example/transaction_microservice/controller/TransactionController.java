package com.example.transaction_microservice.controller;

import com.example.transaction_microservice.entity.TransactionEntity;
import com.example.transaction_microservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:5173")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Create a new transaction
    @PostMapping
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionEntity transaction) {
        TransactionEntity createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.ok(createdTransaction);
    }

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<TransactionEntity>> getAllTransactions() {
        List<TransactionEntity> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    // Get transaction by ID
    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionEntity> getTransactionById(@PathVariable Long transactionId) {
        Optional<TransactionEntity> transaction = transactionService.getTransactionById(transactionId);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update transaction
    @PutMapping("/{transactionId}")
    public ResponseEntity<TransactionEntity> updateTransaction(@PathVariable Long transactionId, @RequestBody TransactionEntity updatedTransaction) {
        TransactionEntity transaction = transactionService.updateTransaction(transactionId, updatedTransaction);
        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransactionEntity> updateTransactionByAdmin(@PathVariable Long id ,@RequestBody TransactionEntity transaction ) {
        transaction = transactionService.updateTransactionByAdmin(id , transaction.getStatus(), transaction.getTotalAmount() , transaction.getPendingAmount() , transaction.getAmountPaid() , transaction.getMonthlyPayment());
        return ResponseEntity.ok(transaction);
    }

    // Delete transaction
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId) {
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.noContent().build();
    }
}