Feature: Accounts

  Background:
    Given there is a user with email "huan@lseg.com" and password "password"

  Scenario: Valid username and password login success
    When login with email "huan@lseg.com" and password "password"
    Then login success

  Scenario: Login fail when password incorrect
    When login with email "zbcjackson@odd-e.com" and password "incorrect-password"
    Then login fail with message "Email and password are invalid."

  Scenario:Empty password login fail
    When login with email "huan@lseg.com" and password ""
    Then login fail with message "Password should not be empty"

  Scenario:Error message prompt when user name incorrect
    When login with email "huan" and password "password"
    Then login fail with message "Email is not valid"

# Accounts test scenarios
  Scenario:Add account successful
    When login with email "huan@lseg.com" and password "password"
    Then Add accounts with "huantest1" and "1"
    Then Verify account "huantest1" displayed in page

  Scenario:User is required for account
    When login with email "huan@lseg.com" and password "password"
    Then Add accounts with "" and "1"
    Then Add fail with message "Name should not be empty"

  Scenario:Balance is required for account
    When login with email "huan@lseg.com" and password "password"
    Then Add accounts with "huantest3" and ""
    Then Add fail with message "Balance should not be empty"

