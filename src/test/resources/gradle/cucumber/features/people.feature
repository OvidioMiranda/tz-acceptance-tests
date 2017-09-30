Feature: People record
  Scenario: A person should record correctly
    Given there is a rest api service client
    When I add Fernando Ayala with Job title DevOps
    Then I get listed the new person
