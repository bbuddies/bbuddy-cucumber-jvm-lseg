Feature: API

  Scenario: SignUp
    Given has a user with email "yong.wang@lseg.com" and password "1234"
    When signup with the given user
    Then the user can signin

    When signup with the existed user again
    Then should success

  Scenario: SignIn
    When signin with email "not.exist@example.com" and password "1234"
    Then throw unauthorized exception

  Scenario: Account
    When add an account with name "Yong Wang" and balance 1000
    Then get "Yong Wang" and balance 1000