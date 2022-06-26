package com.odde.cucumber.step;

import com.odde.cucumber.api.Api;
import com.odde.cucumber.api.dto.User;
import com.odde.cucumber.page.Ui;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class UILoginSteps {

    @Autowired
    private Api api;

    @Autowired
    private Ui ui;

    @When("UI login with email {string} and password {string}")
    public void login_with_email_and_password(String email, String password) {
        ui.open("http://localhost:8100/#/signin");
        ui.input("email", email);
        ui.input("password", password);
        ui.click("login");
    }

    @Then("UI login success")
    public void login_success() {
        ui.assertHaveText("Dashboard");
    }

    @Given("UI there is a user with email {string} and password {string}")
    public void thereIsAUserWithEmailAndPassword(String email, String password) {
        api.signUp(new User(email, password));
    }

    @Then("UI login fail with message {string}")
    public void loginFailWithMessage(String message) {
        ui.assertHaveText(message);
    }

    @When("UI create account with name {string} and Balance {string}")
    public void ui_create_account_with_name_and_balance(String name, String balance) {
        // Write code here that turns the phrase above into concrete actions
        ui.open("http://localhost:8100/#/signin");
        ui.input("email", "zbcjackson@odd-e.com");
        ui.input("password", "password");
        ui.click("login");
        ui.click("Accounts");
        ui.clickByText("Add");
        ui.input("name", name);
        ui.input("balance", balance);
        ui.clickByText("Save");
    }

    @Then("UI account {string} exists")
    public void ui_acount_exists(String account) {
        // Write code here that turns the phrase above into concrete actions
        ui.assertHaveText(account);
    }
}
