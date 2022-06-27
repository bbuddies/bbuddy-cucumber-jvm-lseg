package com.odde.cucumber.step;

import com.github.dockerjava.api.exception.UnauthorizedException;
import com.odde.cucumber.api.Api;
import com.odde.cucumber.api.dto.Account;
import com.odde.cucumber.api.dto.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ApiSteps {

  @Autowired
  private Api api;

  User user = null;
  Throwable throwable = null;

  @Given("has a user with email {string} and password {string}")
  public void hasAUserWithEmailAndPassword(String email, String password) {
    this.user = new User(email, password);
  }

  @When("signup with the given user")
  public void signupWithTheGivenUser() {
    api.signUp(this.user);
  }

  @Then("the user can signin")
  public void theUserCanSignin() {
    api.signIn(user);
  }

  @When("signup with the existed user again")
  public void signupWithTheExistedUserAgain() {
    try {
      api.signUp(this.user);
      api.signUp(this.user);
    } catch (Exception e) {
      this.throwable = e;
    }
  }

  @Then("should success")
  public void shouldSuccess() {
    assertNull(throwable);
  }

  @When("add an account with name {string} and balance {int}")
  public void addAnAccountWithNameAndBalance(String name, int balance) {
    api.addAccount(new Account(name, balance));
  }

  @Then("get {string} and balance {int}")
  public void getAndBalance(String name, int balance) {
    Account account = api.getAccounts().get(0);
    assertEquals(name, account.getName());
    assertEquals((Integer) balance, account.getBalance());
  }

  @When("signin with email {string} and password {string}")
  public void signinWithEmailAndPassword(String name, String password) {
    try {
      api.signIn(new User(name, password));
    } catch (Exception ex) {
      throwable = ex;
    }
  }

  @Then("throw unauthorized exception")
  public void throwUnauthorizedException() {
    assertNotNull(throwable);
    System.out.println(throwable.getMessage());
    assertEquals(UnauthorizedException.class, throwable.getClass());
  }
}
