package com.test.bankingPrototype.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping("")
	public SavingsAccount savings() {
		SavingsAccount savingsAccount = savingsService.getSavingsAccount(1000L);
		return savingsAccount;
	}

	@ResponseBody
	@RequestMapping("/open")
	public Map<String, String> openSavings() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		return map;
	}

	@ResponseBody
	@RequestMapping("/withdraw")
	public Map<String, String> withdrawSavings() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		return map;
	}

	@ResponseBody
	@RequestMapping("/deposit")
	public Map<String, String> depositSavings() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
	    return map;
	}

}

