package com.test.bankingPrototype.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.test.bankingPrototype.entities.CurrentAccount;
import com.test.bankingPrototype.repositories.CurrentRepository;
import com.test.bankingPrototype.utilities.TransactionHistoryUtil;

@Service
public class CurrentService {

	static Logger LOG = LoggerFactory.getLogger(CurrentService.class);

	@Autowired
	CurrentRepository currentRepository;

	@Autowired
	TransactionHistoryUtil transactionHistoryUtil;

	public CurrentAccount getCurrentAccountByHolder(Long accountHolderId) {
		LOG.debug("Fetching Current Account for Account Holder: '{}'", accountHolderId);
		
		CurrentAccount current = currentRepository.findByaccountHolderId(accountHolderId);
		
		return current;
	}

	public CurrentAccount createCurrentAccount(CurrentAccount currentAccount) {
		LOG.debug("Create Current Account: '{}'", currentAccount);
		CurrentAccount newCurrentAccount = currentRepository.saveAndFlush(currentAccount);

		if (ObjectUtils.isEmpty(newCurrentAccount)) {
			return null;
		} else {
			return newCurrentAccount;
		}
	}

	public CurrentAccount depositCurrentAccount(CurrentAccount currentAccount) {
		LOG.debug("Deposit into Current Account: '{}'", currentAccount);
		CurrentAccount dbCurrentAccount = currentRepository.findByaccountHolderId(currentAccount.getAccountHolderId());
		CurrentAccount updatedCurrentAccount = null;

		if (ObjectUtils.isEmpty(dbCurrentAccount)) {
			LOG.info("Going to Create Current Account: '{}'", currentAccount);
			updatedCurrentAccount = createCurrentAccount(currentAccount);

			if (ObjectUtils.isEmpty(updatedCurrentAccount)) {
				return null;
			} else {
				return updatedCurrentAccount;
			}
		} else {
			Double oldBalance = dbCurrentAccount.getAccountAmount();
			Double newBalance = oldBalance + currentAccount.getAccountAmount();
			dbCurrentAccount.setAccountAmount(newBalance);
			updatedCurrentAccount = currentRepository.saveAndFlush(dbCurrentAccount);

			if (ObjectUtils.isEmpty(updatedCurrentAccount)) {
				return null;
			} else {
				transactionHistoryUtil.saveNewTransactionHistoryEntity("Deposit",
						updatedCurrentAccount.getAccountHolderId(), "Current Account",
						oldBalance, newBalance);

				return updatedCurrentAccount;
			}
		}
	}

	public CurrentAccount withdrawCurrentAccount(CurrentAccount currentAccount) {
		LOG.debug("Withdraw from Current Account: '{}'", currentAccount);
		CurrentAccount dbCurrentAccount = currentRepository.findByaccountHolderId(currentAccount.getAccountHolderId());
		CurrentAccount updatedCurrentAccount = null;
		double overdraftLimit = 100000.00;

		if (ObjectUtils.isEmpty(dbCurrentAccount)) {
			return null;
		} else {
			Double oldOverdraftBalance = dbCurrentAccount.getAccountOverdraftAmount();
			Double newOverdraftBalance = oldOverdraftBalance + currentAccount.getAccountOverdraftAmount();

			if (newOverdraftBalance > (dbCurrentAccount.getAccountAmount() + overdraftLimit)) {
				return null;
			} else {
				dbCurrentAccount.setAccountOverdraftAmount(newOverdraftBalance);
				updatedCurrentAccount = currentRepository.saveAndFlush(dbCurrentAccount);

				if (ObjectUtils.isEmpty(updatedCurrentAccount)) {
					return null;
				} else {
					transactionHistoryUtil.saveNewTransactionHistoryEntity("Withdraw",
							updatedCurrentAccount.getAccountHolderId(), "Current Account",
							oldOverdraftBalance, newOverdraftBalance);

					return updatedCurrentAccount;
				}
			}
		}
	}

}














