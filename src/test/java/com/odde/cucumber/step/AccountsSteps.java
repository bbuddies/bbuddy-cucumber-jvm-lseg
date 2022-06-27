package com.odde.cucumber.step;
import com.odde.cucumber.api.Api;

import com.odde.cucumber.page.Ui;

import io.cucumber.java.en.Then;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountsSteps {
    @Autowired
    private Api api;

    @Autowired
    private Ui ui;

    @Then("Add accounts with {string} and {string}")
    public void add_accounts(String user, String balance) {
        ui.assertHaveText("Dashboard");
        ui.click("Accounts");
        ui.clickByText("Add");

        // Input account as UI
        ui.input("name",user);
        ui.input("balance", balance);
        ui.clickByText("Save");

    }
    @Then("Verify account {string} displayed in page")
    public void account_displayed(String user) {
        ui.assertHaveText(user);
        System.out.println("Account add successfully");

    }

    @Then("Add fail with message {string}")
    public void account_fail_error(String message) {
        ui.assertHaveText(message);
        System.out.println("Account not added due to: " + message);
    }

}
