package com.test.bankingPrototype.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURRENT")
public class CurrentAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	private Long accountHolderId;
	private double accountAmount;

	public CurrentAccount() {

	}

	public CurrentAccount(Long accountId, Long accountHolder, double accountAmount) {
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
