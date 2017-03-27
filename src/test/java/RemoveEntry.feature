Feature: Remove entry

  Scenario: User removes existing entry
    Given entry exists
    When user removes entry
    Then entry is removed

  Scenario: User ask to remove not existing entry
    Given entry doesn't exist
    When user asks about removing entry by name
    Then message "Entry not found" occurs