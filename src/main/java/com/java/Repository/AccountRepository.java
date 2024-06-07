package com.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
