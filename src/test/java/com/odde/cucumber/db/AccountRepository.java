package com.odde.cucumber.db;

import com.odde.cucumber.db.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Query(
            value = "truncate table account",
            nativeQuery = true
    )
    void truncate();
}
