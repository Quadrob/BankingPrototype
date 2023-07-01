package com.test.bankingPrototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingPrototypeApplication {

	static Logger LOG = LoggerFactory.getLogger(BankingPrototypeApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(BankingPrototypeApplication.class, args);
		} catch (Throwable e) {
			LOG.error("Error Initializing App: ", e);
			throw e;
		}
	}
}
