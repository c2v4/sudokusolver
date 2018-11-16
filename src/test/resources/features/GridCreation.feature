Feature: Grid creation

  Scenario: Create 2x2 Grid

    When I create a Grid with structure
    """
    1 2
    2 3
    """
    Then The Grid should be created
