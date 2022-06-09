package com.odde.cucumber;

import com.odde.cucumber.db.AccountRepository;
import com.odde.cucumber.db.UserRepository;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired

    @Before(order = 0)
    public void truncate() {
        accountRepository.truncate();
        userRepository.truncate();
    }

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

}
