package com.odde.cucumber.step;

import com.odde.cucumber.api.Api;
import com.odde.cucumber.api.dto.User;
import com.odde.cucumber.page.Ui;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {

    @Autowired
    private Api api;

    @Autowired
    private Ui ui;

    @When("login with email {string} and password {string}")
    public void login_with_email_and_password(String email, String password) {
        ui.open("http://localhost:8100/#/signin");
        ui.input("email", email);
        ui.input("password", password);
        ui.click("login");
    }

    @When("login with email {string}")
    public void loginWithEmail(String email) {
        ui.open("http://localhost:8100/#/signin");
        ui.input("email", email);
        ui.click("login");
    }

    @When("login with password {string}")
    public void loginWithPassword(String passwd) {
        ui.open("http://localhost:8100/#/signin");
        ui.input("password", passwd);
        ui.click("login");
    }

    @When("login with no email nor password")
    public void loginWithNoEmailNorPassword() {
        ui.open("http://localhost:8100/#/signin");
        ui.click("login");
    }

    @Then("login success")
    public void login_success() {
        ui.assertHaveText("Dashboard");
    }

    @Given("there is a user with email {string} and password {string}")
    public void thereIsAUserWithEmailAndPassword(String email, String password) {
        api.signUp(new User(email, password));
    }

    @Then("login fail with message {string}")
    public void loginFailWithMessage(String message) {
        ui.assertHaveText(message);
    }

    @When("add account {string} and balance {string}")
    public void addAccountAndBalance(String name, String balance) {
        ui.open("http://localhost:8100/#/accounts/add");
        ui.input("name", name);
        ui.input("balance", balance);
        ui.click("save");
    }

    @Then("account {string} and balance {string} add succeed")
    public void accountAndBalanceAddSucceed(String account, String balance) {
        ui.open("http://localhost:8100/#/accounts");
        ui.assertHaveContent(account);
        ui.assertHaveContent(balance);
    }

    @Then("account {string} and balance {string} failed with empty balance")
    public void accountAndBalanceFailedWithEmptyBalance(String account, String balance) {
        ui.assertHaveContent(account);
        ui.assertHaveContent(balance);
        ui.assertHaveContent("Balance should not be empty");
    }

    @When("add account {string}")
    public void addAccount(String account) {
        ui.open("http://localhost:8100/#/accounts/add");
        ui.assertHaveContent(account);
        ui.click("save");
    }

    @When("add balance {string}")
    public void addBalance(String balance) {
        ui.open("http://localhost:8100/#/accounts/add");
        ui.input("balance", balance);
        ui.click("save");
    }

    @When("click add directly")
    public void clickAddDirectly() {
        ui.open("http://localhost:8100/#/accounts/add");
        ui.click("save");
    }

    @Then("failed with {string}")
    public void failedWith(String text) {
        ui.assertHaveContent(text);
    }

    @Then("account {string} found duplicate")
    public void accountFoundDuplicate(String name) {
        ui.open("http://localhost:8100/#/accounts");
        ui.assertHaveDuplicatedContent(name);
    }

    @Then("found text {string}")
    public void foundText(String text) {
        ui.assertHaveContent(text);
    }
}
