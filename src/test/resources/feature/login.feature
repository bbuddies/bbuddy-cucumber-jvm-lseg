Feature: Login
  Background:
    Given there is a user with email "zbcjackson@odd-e.com" and password "password"

  Scenario: success
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success

  Scenario: fail
    When login with email "zbcjackson@odd-e.com" and password "incorrect-password"
    Then login fail with message "Email and password are invalid."