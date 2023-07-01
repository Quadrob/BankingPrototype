package com.test.bankingPrototype.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.bankingPrototype.entities.SavingsAccount;
import com.test.bankingPrototype.services.SavingsService;

@RestController
@RequestMapping("/api/savings")
public class SavingsController {

	static Logger LOG = LoggerFactory.getLogger(SavingsController.class);

	@Autowired
	SavingsService savingsService;

	@ResponseBody
	@GetMapping("/{id}")
	public SavingsAccount savings(@PathVariable("id") Long id) {
		SavingsAccount savingsAccount = savingsService.getSavingsAccountByHolder(id);
		LOG.info("Fetched Savings Account: '{}'", savingsAccount);

		return savingsAccount;
	}

	@ResponseBody
	@PostMapping("/withdraw")
	public SavingsAccount withdrawSavings(@RequestBody SavingsAccount savingsAccount) {
		SavingsAccount savings = savingsService.withdrawSavingsAccount(savingsAccount);

		if (ObjectUtils.isEmpty(savings)) {
			LOG.error("Failed to Deposit for Savings Account: '{}'", savingsAccount);
			return null;
		} else {
			LOG.info("Succesful Deposit for: '{}'", savings.getAccountId());
			return savings;
		}
	}

	@ResponseBody
	@PostMapping("/deposit")
	public SavingsAccount depositSavings(@RequestBody SavingsAccount savingsAccount) {
		SavingsAccount savings = savingsService.depositSavingsAccount(savingsAccount);

		if (ObjectUtils.isEmpty(savings)) {
			LOG.error("Failed to Deposit for Savings Account: '{}'", savingsAccount);
			return null;
		} else {
			LOG.info("Succesful Deposit for: '{}'", savings.getAccountId());
			return savings;
		}
	}

}











