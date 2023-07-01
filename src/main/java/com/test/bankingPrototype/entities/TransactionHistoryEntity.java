package com.test.bankingPrototype.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSACTIONS")
public class TransactionHistoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private String transactionType;
	private LocalDateTime transactionTimestamp;

	private Long accountHolderId;
	private String accountTypeString;
	private double accountOldAmount;
	private double accountNewAmount;


	public TransactionHistoryEntity() {

	}

	public TransactionHistoryEntity(Long transactionId, String transactionType, LocalDateTime transactionTimestamp,
			Long accountHolderId, String accountTypeString, double accountOldAmount, double accountNewAmount) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionTimestamp = transactionTimestamp;
		this.accountHolderId = accountHolderId;
		this.accountTypeString = accountTypeString;
		this.accountOldAmount = accountOldAmount;
		this.accountNewAmount = accountNewAmount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(LocalDateTime transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}

	public Long getAccountHolderId() {
		return accountHolderId;
	}

	public void setAccountHolderId(Long accountHolderId) {
		this.accountHolderId = accountHolderId;
	}

	public String getAccountTypeString() {
		return accountTypeString;
	}

	public void setAccountTypeString(String accountTypeString) {
		this.accountTypeString = accountTypeString;
	}

	public double getAccountOldAmount() {
		return accountOldAmount;
	}

	public void setAccountOldAmount(double accountOldAmount) {
		this.accountOldAmount = accountOldAmount;
	}

	public double getAccountNewAmount() {
		return accountNewAmount;
	}

	public void setAccountNewAmount(double accountNewAmount) {
		this.accountNewAmount = accountNewAmount;
	}

}








