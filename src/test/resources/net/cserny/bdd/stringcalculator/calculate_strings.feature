Feature: Calculating Strings

  Scenario: Calculation sum of numbers string
    Given numbers string "1,2,3"
    When adding
    Then return sum of all numbers in string as 6