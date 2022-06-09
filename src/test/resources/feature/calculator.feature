Feature: Calculator

  Scenario: Add
    When add 1 and 1
    Then get 2

  Scenario: Subtraction
    When subtract 1 from 2
    Then get 1