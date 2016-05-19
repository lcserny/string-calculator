Feature: Adding Numbers

  Scenario:Adding numbers array to return their sum
    Given numbers array
    When adding
    Then return their sum

  Scenario: Negative numbers not allowed
    Given negative numbers array
    When adding
    Then throw negatives not allowed exception
    And the error message should show the negative numbers

  Scenario: Exclude numbers bigger than 1000
    Given number bigger than 1000
    When adding
    Then ignore it