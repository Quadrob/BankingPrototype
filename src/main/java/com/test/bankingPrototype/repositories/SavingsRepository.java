package com.test.bankingPrototype.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.bankingPrototype.entities.SavingsAccount;

@Repository
public interface SavingsRepository extends CrudRepository<SavingsAccount, Long> {

}
