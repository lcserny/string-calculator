Feature: Adding Numbers

  Scenario:Adding numbers array to return their sum
    Given numbers array [1,2,3]
    When adding
    Then return their sum as 6

  Scenario: Negative numbers not allowed
    Given negative numbers array [-1,3,-5]
    When adding
    Then throw negatives not allowed exception
    And the error message should be "Negatives not allowed: -1 -5"

  Scenario: Exclude numbers bigger than 1000
    Given numbers string with number bigger than 1000 "2,1,1033"
    When adding
    Then ignore the big number and sum the rest to 3