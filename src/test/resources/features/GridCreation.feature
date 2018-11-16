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


  Scenario: Create 3x2 Grid - should fail

    When I safely create a Grid with structure
    """
    1 2
    3 4
    4 5
    """
    Then It should fail due to "Number of rows is not a square number"

  Scenario: Create 3x3 Grid - should fail

    When I safely create a Grid with structure
    """
    1 2 4
    3 4 6
    4 5 8
    """
    Then It should fail due to "Number of rows is not a square number"

  Scenario: Create 2x3 Grid - should fail

    When I safely create a Grid with structure
    """
    1 2 4
    3 4 5
    """
    Then It should fail due to "Input is not a full square"


  Scenario: Create 4x4 Grid

    When I create a Grid with structure
    """
    1 2 4 5
    3 4 5 7
    1 2 4 5
    3 4 5 7
    """
    Then The Grid should be created
