package com.test.bankingPrototype.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/current")
public class CurrentController {

	static Logger LOG = LoggerFactory.getLogger(CurrentController.class);

	@ResponseBody
	@RequestMapping("")
	public Map<String, String> current() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		map.put("body", "This is the savings controller!");
		return map;
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


