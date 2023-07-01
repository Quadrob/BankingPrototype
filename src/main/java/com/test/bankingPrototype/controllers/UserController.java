package com.test.bankingPrototype.controllers;

import java.util.HashMap;
import java.util.Map;

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

import com.test.bankingPrototype.entities.UserAccount;
import com.test.bankingPrototype.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	static Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@ResponseBody
	@GetMapping("/{id}")
	public UserAccount savings(@PathVariable("id") Long id) {
		UserAccount userAccount = userService.getUserAccountById(id);
		LOG.info("Fetched User Account: '{}'", userAccount);

		return userAccount;
	}

	@ResponseBody
	@PostMapping("/login")
	public UserAccount login(@RequestBody UserAccount user) {
		UserAccount userAcccount = userService.loginUser(user);

		if (ObjectUtils.isEmpty(userAcccount)) {
			return userAcccount;
		} else {
			return userAcccount;
		}
	}

	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> create() {
		Map<String, String> map = new HashMap<>();
		map.put("status", "200");
		return map;
	}

}



