Feature: Get entry by name

  Scenario: User ask about existing entry
    Given entry exists
    When user asks about entry by name
    Then phone number is given

  Scenario: User ask about not existing entry
    Given entry doesn't exist
    When user asks about entry by name
    Then message "Entry not found" occurs

