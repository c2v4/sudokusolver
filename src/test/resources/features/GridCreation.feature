Feature: Grid creation

  Scenario: Create 2x2 Grid

    When I create a Grid with structure
    """
    1 2
    2 3
    """
    Then The Grid should be created


  Scenario: Create 2x2 Grid with field check

    When I create a Grid with structure
    """
    1 2
    3 4
    """
    Then The Grid should should have 1 in row 0, column 0
    And The Grid should should have 2 in row 0, column 1
    And The Grid should should have 3 in row 1, column 0
    And The Grid should should have 4 in row 1, column 1