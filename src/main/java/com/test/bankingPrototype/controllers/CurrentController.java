package com.test.bankingPrototype.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("/{id}")
	public CurrentAccount current(@PathVariable("id") Long id) {
		CurrentAccount currentAccount = currentService.getCurrentAccountByHolder(id);
		LOG.info("Fetched Curreent Account: '{}'", currentAccount);

		return currentAccount;
	}

	@ResponseBody
	@RequestMapping("/open")
	public Map<String, String> openCurrent() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		return map;
	}

	@ResponseBody
	@RequestMapping("/withdraw")
	public Map<String, String> withdrawCurrent() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		return map;
	}

	@ResponseBody
	@RequestMapping("/deposit")
	public Map<String, String> depositCurrent() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
	    return map;
	}

}


