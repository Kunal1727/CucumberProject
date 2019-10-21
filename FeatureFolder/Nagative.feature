@Sanity
Feature: Negative Scenario

  Scenario Outline: Corret username and incorrect password
    Given the site is up and running
    When I provide <username> and <password>
    Then I validate I should not logged in

    Examples: 
      | username  | password   |
      | admin     | admin12345 |
      | admindemo | admin123   |
      | admindemo | admin12345 |
