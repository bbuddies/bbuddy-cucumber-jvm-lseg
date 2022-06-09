package com.odde.cucumber.api;

import com.odde.cucumber.api.client.AccountsClient;
import com.odde.cucumber.api.client.UsersClient;
import com.odde.cucumber.api.dto.Account;
import com.odde.cucumber.api.dto.User;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Api {
    @Autowired
    private AccountsClient accountsClient;

    @Autowired
    private UsersClient usersClient;

    public void addAccount(Account account) {
        accountsClient.addAccount(account);
    }

    public List<Account> getAccounts() {
        return accountsClient.getAccounts();
    }

    public void signUp(User user) {
        usersClient.signUp(user);
    }

    public void signIn(User user) {
        try (Response response = usersClient.signIn(user)) {
            Feign.authorization = response.headers().get("Authorization").stream().findFirst().get();
        }
    }
}
