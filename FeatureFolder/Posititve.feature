@Smoke
Feature: Positive Scenario

  Scenario: Correct username and password
    Given the site is up and running
    When I provide correct credentials
    Then I validate I should logged in
