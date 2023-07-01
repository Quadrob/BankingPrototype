package com.test.bankingPrototype.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.bankingPrototype.entities.UserAccount;

@Repository
public interface UserRepository extends CrudRepository<UserAccount, Long> {

}
