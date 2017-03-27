Feature: List all entries

  Scenario: User asks about the list of entries
    Given list of entries exist
    When user ask about list of entries
    Then entries are listed

  Scenario: User ask about the list when no entry exist
    Given entry doesn't exist
    When user ask about list of entries
    Then is asked to create first entry

