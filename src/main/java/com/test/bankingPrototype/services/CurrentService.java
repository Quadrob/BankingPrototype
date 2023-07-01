package com.test.bankingPrototype.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bankingPrototype.entities.CurrentAccount;
import com.test.bankingPrototype.repositories.CurrentRepository;

@Service
public class CurrentService {

	static Logger LOG = LoggerFactory.getLogger(CurrentService.class);

	@Autowired
	CurrentRepository currentRepository;

	public CurrentAccount getCurrentAccountByHolder(Long accountHolderId) {
		LOG.debug("Fetching Current Account for Account Holder: '{}'", accountHolderId);
		
		CurrentAccount current = currentRepository.findByaccountHolderId(accountHolderId);
		
		return current;
	}

}














