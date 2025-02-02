package com.example.transaction_microservice.repository;

import com.example.transaction_microservice.entity.TransactionEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByLoanApprovalId(Long loanApprovalId);

}