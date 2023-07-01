package com.test.bankingPrototype.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.bankingPrototype.entities.SavingsAccount;

@Repository
public interface SavingsRepository extends JpaRepository<SavingsAccount, Long> {

	SavingsAccount findByaccountHolderId(Long accountHolderId);
}
