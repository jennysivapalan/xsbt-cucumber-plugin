@example-jar
Feature: Cucumber in Jar Project
  In order to implement BDD in my Scala project
  As a developer
  I want to be able to run Cucumber from with SBT

  Scenario: Execute feature in a Jar Project
    Given an SBT project
    When the cucumber task is called
    Then Cucumber is executed against the features and step definitions

  Scenario: DataTable
     Given I have the following foods :
       | FOOD   | CALORIES |
       | cheese |      500 |
       | burger |     1000 |
       | fries  |      750 |
     Then calories total is "2250.0"