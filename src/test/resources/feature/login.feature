Feature: Login
  Background:
    Given there is a user with email "zbcjackson@odd-e.com" and password "password"

  Scenario: login_success
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success

  Scenario: fail_incorrect_passwd
    When login with email "zbcjackson@odd-e.com" and password "incorrect-password"
    Then login fail with message "Email and password are invalid."

  Scenario: fail_nonexisting_email
    When login with email "zbcjackson@odd-e-dummy.com" and password "incorrect-password"
    Then login fail with message "Email and password are invalid."

  Scenario: fail_no_passwd
    When login with email "zbcjackson@odd-e-dummy.com"
    Then login fail with message "Password should not be empty"

  Scenario: fail_no_email
    When login with password "incorrect-password"
    Then login fail with message "Email should not be empty"

  Scenario: fail_no_input
    When login with no email nor password
    Then login fail with message "Email should not be empty"
    Then login fail with message "Password should not be empty"

  Scenario: account_add_success
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success
    When add account "wangbb" and balance "10"
    Then account "wangbb" and balance "10" add succeed

  Scenario: account_add_fail_balance_0
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success
    When add account "wangbb" and balance "0"
    Then account "wangbb" and balance "0" failed with empty balance

  Scenario: account_add_fail_no_name_10
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success
    When add balance "10"
    Then failed with "Name should not be empty"

  Scenario: account_add_fail_no_name_0
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success
    When add balance "0"
    Then failed with "Name should not be empty"

  Scenario: account_add_fail_no_name_no_balance
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success
    When click add directly
    Then failed with "Balance should not be empty"
    Then failed with "Name should not be empty"

  Scenario: account_add_fail_negative_balance
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success
    When add account "wangbb" and balance "-9"
    Then failed with "Something bad happened"

  Scenario: account_add_duplicate_success
    When login with email "zbcjackson@odd-e.com" and password "password"
    Then login success
    When add account "wangbb" and balance "10"
    When add account "wangbb" and balance "20"
    Then account "wangbb" found duplicate
    Then found text "10"
    Then found text "20"