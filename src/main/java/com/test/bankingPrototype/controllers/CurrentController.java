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

import com.test.bankingPrototype.entities.CurrentAccount;
import com.test.bankingPrototype.services.CurrentService;

@RestController
@RequestMapping("/api/current")
public class CurrentController {

	static Logger LOG = LoggerFactory.getLogger(CurrentController.class);

	@Autowired
	CurrentService currentService;

	@ResponseBody
	@GetMapping("/{id}")
	public CurrentAccount current(@PathVariable("id") Long id) {
		CurrentAccount currentAccount = currentService.getCurrentAccountByHolder(id);
		LOG.info("Fetched Curreent Account: '{}'", currentAccount);

		return currentAccount;
	}

	@ResponseBody
	@PostMapping("/open")
	public CurrentAccount openCurrent(@RequestBody CurrentAccount currentAccount) {
		currentAccount.setAccountAmount(0);
		currentAccount.setAccountOverdraftAmount(0);
		CurrentAccount current = currentService.createCurrentAccount(currentAccount);

		if (ObjectUtils.isEmpty(current)) {
			LOG.error("Failed to Create Current Account: '{}'", currentAccount);
			return null;
		} else {
			LOG.info("Succesfully Created Current Account: '{}'", current.getAccountId());
			return current;
		}

	}

	@ResponseBody
	@PostMapping("/withdraw")
	public CurrentAccount withdrawCurrent(@RequestBody CurrentAccount currentAccount) {
		CurrentAccount current = currentService.withdrawCurrentAccount(currentAccount);

		if (ObjectUtils.isEmpty(current)) {
			LOG.error("Failed to Withdraw from Current Account: '{}'", currentAccount.getAccountId());
			return null;
		} else {
			LOG.info("Succesfully Withdrew from Current Account: '{}'", current.getAccountId());
			return current;
		}

	}

	@ResponseBody
	@PostMapping("/deposit")
	public CurrentAccount depositCurrent(@RequestBody CurrentAccount currentAccount) {
		CurrentAccount current = currentService.depositCurrentAccount(currentAccount);

		if (ObjectUtils.isEmpty(current)) {
			LOG.error("Failed to Deposit to Current Account: '{}'", currentAccount.getAccountId());
			return null;
		} else {
			LOG.info("Succesful Deposit for Current Account: '{}'", current.getAccountId());
			return current;
		}

	}

}







