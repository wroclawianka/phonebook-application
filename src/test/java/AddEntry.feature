Feature: Add entry

  Scenario: User adds valid entry
    When user gives name and phone number
    Then entry is added

  Scenario: User adds entry with existing name
    Given entry exists
    When user gives existing name and phone number
    Then is asked to set another name

  Scenario: User adds entry with too long name
    When user gives too long name and phone number
    Then is asked to set another name

  Scenario: User adds entry with empty name
    When user gives empty name and phone number
    Then is asked to set another name

  Scenario: User adds entry with too long phone number
    When  user gives name and too long phone number
    Then is asked to set another name

  Scenario: User adds entry with empty phone number
    When user gives name and empty phone number
    Then is asked to set another name

