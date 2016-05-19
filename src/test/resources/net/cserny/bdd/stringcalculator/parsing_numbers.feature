Feature: Parsing Numbers

  Scenario:
    Given empty string ""
    When getting numbers
    Then return empty array

  Scenario:
    Given one number string "2"
    When getting numbers
    Then return array with the number [2]

  Scenario:
    Given two numbers string "1,2"
    When getting numbers
    Then return array with the numbers [1,2]

  Scenario:
    Given unknown amount of numbers in string, comma delimited "1,2,3,4,5"
    When getting numbers
    Then return array with the nubmers [1,2,3,4,5]

  Scenario:
    Given newline delimited numbers in string "4\n5\n6"
    When getting nubmers
    Then return array with the numbers [4,5,6]

  Scenario:
    Given numbers string with custom delimiter syntax "//;\n3;2;1"
    When getting nubmers
    Then return array with the numbers [3,2,1]

  Scenario:
    Given multi-character custom delimiter syntax "//[***]\n4***6"
    When getting nubmers
    Then return array with the numbers [4,6]

  Scenario:
    Given multiple multi-character custom delimiter syntax "//[%][&]\n2%4&7"
    When getting nubmers
    Then return array with the numbers [2,4,7]