Feature: Parsing Numbers

  Scenario:
    Given empty string
    When getting numbers
    Then return empty array

  Scenario:
    Given one number string
    When getting numbers
    Then return array with the number

  Scenario:
    Given two numbers string
    When getting numbers
    Then return array with the numbers

  Scenario:
    Given unknown amount of numbers in string, comma delimited
    When getting numbers
    Then return array with the nubmers

  Scenario:
    Given newline delimited numbers in string
    When getting nubmers
    Then return array with the numbers

  Scenario:
    Given numbers string with custom delimiter syntax
    When getting nubmers
    Then return array with the numbers

  Scenario:
    Given multi-character custom delimiter syntax
    When getting nubmers
    Then return array with the numbers

  Scenario:
    Given multiple multi-character custom delimiter syntax
    When getting nubmers
    Then return array with the numbers