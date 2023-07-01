package com.test.bankingPrototype.utilities;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.test.bankingPrototype.entities.TransactionHistoryEntity;
import com.test.bankingPrototype.repositories.TransactionHistoryRepository;

@Component
public class TransactionHistoryUtil {

	static Logger LOG = LoggerFactory.getLogger(TransactionHistoryUtil.class);

	@Autowired
	TransactionHistoryRepository transactionHistoryRepository;

	public void saveNewTransactionHistoryEntity(String transactionType, Long accountHolderId, String accountTypeString,
			double accountOldAmount, double accountNewAmount) {

		TransactionHistoryEntity transactionHistoryEntity = new TransactionHistoryEntity();
		transactionHistoryEntity.setTransactionType(transactionType);
		transactionHistoryEntity.setTransactionTimestamp(LocalDateTime.now());

		transactionHistoryEntity.setAccountHolderId(accountHolderId);
		transactionHistoryEntity.setAccountTypeString(accountTypeString);
		transactionHistoryEntity.setAccountOldAmount(accountOldAmount);
		transactionHistoryEntity.setAccountNewAmount(accountNewAmount);

		TransactionHistoryEntity newTransactionHistoryEntity = transactionHistoryRepository.saveAndFlush(transactionHistoryEntity);

		if (ObjectUtils.isEmpty(newTransactionHistoryEntity)) {
			LOG.error("Failed to Create New Transaction History Entity: '{}'", transactionHistoryEntity);
		} else {
			LOG.info("New Transaction History Entity: '{}'", newTransactionHistoryEntity);
		}
	}

}














