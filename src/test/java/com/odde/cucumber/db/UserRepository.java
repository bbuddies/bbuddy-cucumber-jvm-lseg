package com.odde.cucumber.db;

import com.odde.cucumber.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(
            value = "truncate table user",
            nativeQuery = true
    )
    void truncate();
}
