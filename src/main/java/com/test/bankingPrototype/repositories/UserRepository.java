package com.test.bankingPrototype.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.bankingPrototype.entities.UserAccount;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {

}
