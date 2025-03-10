package com.example.transaction_microservice.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_number")
    private Long transactionNumber;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "loan_approval_id", nullable = false)
    private Long loanApprovalId;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "transaction_amount", nullable = false)
    private Double transactionAmount;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "pending_amount")
    private Double pendingAmount;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "monthly_payment")
    private Double monthlyPayment;

    @Column(name = "status")
    private String status = "PENDING";

    
    public Long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionId(Long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getLoanApprovalId() {
        return loanApprovalId;
    }

    public void setLoanApprovalId(Long loanApprovalId) {
        this.loanApprovalId = loanApprovalId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(Double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}