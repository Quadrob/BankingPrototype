package com.test.bankingPrototype.savings.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/savings")
public class SavingsController {

	static Logger LOG = LoggerFactory.getLogger(SavingsController.class);

	@ResponseBody
	@RequestMapping("")
	public Map<String, String> savings() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("body", "This is the savings controller!");
		return map;
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

