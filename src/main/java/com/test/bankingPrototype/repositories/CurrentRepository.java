package com.test.bankingPrototype.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.bankingPrototype.entities.CurrentAccount;

@Repository
public interface CurrentRepository extends CrudRepository<CurrentAccount, Long> {

}
