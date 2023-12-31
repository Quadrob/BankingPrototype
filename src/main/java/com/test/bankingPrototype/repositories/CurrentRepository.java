package com.test.bankingPrototype.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.bankingPrototype.entities.CurrentAccount;

@Repository
public interface CurrentRepository extends JpaRepository<CurrentAccount, Long> {

	CurrentAccount findByaccountHolderId(Long accountHolderId);
}
