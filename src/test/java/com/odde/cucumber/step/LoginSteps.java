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
}
