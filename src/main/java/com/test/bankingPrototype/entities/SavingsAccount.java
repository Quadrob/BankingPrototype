package com.test.bankingPrototype.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SAVINGS")
public class SavingsAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

	@Column(unique = true)
	private Long accountHolderId;

	private double accountAmount;


	public SavingsAccount() {

	}

	public SavingsAccount(Long accountId, Long accountHolder, double accountAmount) {
		super();
		this.accountId = accountId;
		this.accountHolderId = accountHolder;
		this.accountAmount = accountAmount;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountHolder() {
		return accountHolderId;
	}

	public void setAccountHolder(Long accountHolder) {
		this.accountHolderId = accountHolder;
	}

	public double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(double accountAmount) {
		this.accountAmount = accountAmount;
	}

}
