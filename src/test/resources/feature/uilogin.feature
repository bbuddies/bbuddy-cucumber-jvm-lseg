Feature: UILogin

  Background:
    Given UI there is a user with email "zbcjackson@odd-e.com" and password "password"

  Scenario: success
    When UI login with email "zbcjackson@odd-e.com" and password "password"
    Then UI login success

  Scenario: fail
    When UI login with email "zbcjackson@odd-e.com" and password "incorrect-password"
    Then UI login fail with message "Email and password are invalid."

  Scenario: add account "name001"
    When UI create account with name "name001" and Balance "001"
    Then UI account "name001" exists