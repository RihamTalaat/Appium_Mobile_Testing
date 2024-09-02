Feature: Register and search
  As a user
  I want to register on the website
  So that I can search without Filter  and  I can search with Filter

  Scenario: Register,search without Filter , and Change search with Filter
    Given I am on the home page
    When I register with valid details
    Then I can search without Filter
    And I can search with Filter