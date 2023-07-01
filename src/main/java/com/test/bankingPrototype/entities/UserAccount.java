package com.test.bankingPrototype.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANK_USERS")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

	@Column(unique = true)
	private String name;

	private String password;


	public UserAccount() {

	}

	public UserAccount(Long accountId, String name, String password) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.password = password;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
