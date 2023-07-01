package com.test.bankingPrototype.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.test.bankingPrototype.entities.UserAccount;
import com.test.bankingPrototype.repositories.UserRepository;

@Service
public class UserService {

	static Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	public UserAccount getUserAccountById(Long accountId) {
		LOG.debug("Fetching User Account with Id: '{}'", accountId);
		
		UserAccount user = userRepository.findById(accountId).get();
		
		return user;
	}

	public UserAccount loginUser(UserAccount userAccount) {
		LOG.debug("Logging In User Account with Name: '{}'", userAccount.getName());

		UserAccount user = userRepository.findByname(userAccount.getName());
		
		if (ObjectUtils.isEmpty(user)) {
			return null;
		} else {
			return user.getPassword() == userAccount.getPassword() ? user : null;
		}
	}

}














