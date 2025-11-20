package com.codeit.jpastudy.chap05.repository;

import com.codeit.jpastudy.chap05.entity.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // method 선언
    Optional<Account> findByAccountNumber(String accountNumber);


}
