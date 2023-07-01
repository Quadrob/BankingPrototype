package com.test.bankingPrototype.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bankingPrototype.entities.SavingsAccount;
import com.test.bankingPrototype.repositories.SavingsRepository;

@Service
public class SavingsService {

	static Logger LOG = LoggerFactory.getLogger(SavingsService.class);

	@Autowired
	SavingsRepository savingsRepository;

	public SavingsAccount getSavingsAccount(Long accountHolderId) {
		LOG.info("Fetching Savings Account for Account Holder: '{}'", accountHolderId);
		
		SavingsAccount savings = savingsRepository.findByaccountHolderId(accountHolderId);
		
		return savings;
	}

}














