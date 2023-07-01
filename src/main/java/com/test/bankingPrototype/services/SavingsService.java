package com.test.bankingPrototype.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.test.bankingPrototype.entities.SavingsAccount;
import com.test.bankingPrototype.repositories.SavingsRepository;

@Service
public class SavingsService {

	static Logger LOG = LoggerFactory.getLogger(SavingsService.class);

	@Autowired
	SavingsRepository savingsRepository;

	public SavingsAccount getSavingsAccountByHolder(Long accountHolderId) {
		LOG.debug("Fetching Savings Account for Account Holder: '{}'", accountHolderId);
		
		SavingsAccount savings = savingsRepository.findByaccountHolderId(accountHolderId);
		
		return savings;
	}

	public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
		LOG.debug("Create Savings Account with Name: '{}'", savingsAccount);
		SavingsAccount newSavingsAccount = null;

		if (savingsAccount.getAccountAmount() > 1000.00) {
			newSavingsAccount = savingsRepository.saveAndFlush(savingsAccount);
		} else {
			return null;
		}

		if (ObjectUtils.isEmpty(newSavingsAccount)) {
			return null;
		} else {
			return newSavingsAccount;
		}
	}

	public SavingsAccount depositSavingsAccount(SavingsAccount savingsAccount) {
		LOG.debug("Deposit into Savings Account: '{}'", savingsAccount.getAccountId());
		SavingsAccount dbSavingsAccount = savingsRepository.findById(savingsAccount.getAccountId()).get();
		SavingsAccount updatedSavingsAccount = null;

		if (ObjectUtils.isEmpty(dbSavingsAccount) && savingsAccount.getAccountAmount() > 1000.00) {
			LOG.info("Going to Create Savings Account: '{}'", savingsAccount);
			updatedSavingsAccount = createSavingsAccount(savingsAccount);

			if (ObjectUtils.isEmpty(updatedSavingsAccount)) {
				return null;
			} else {
				return updatedSavingsAccount;
			}
		} else {
			dbSavingsAccount.setAccountAmount(savingsAccount.getAccountAmount());
			updatedSavingsAccount = savingsRepository.saveAndFlush(dbSavingsAccount);
			return updatedSavingsAccount;
		}
	}

}














