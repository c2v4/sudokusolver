Feature: StringRepresentation


  @ignored
  Scenario: ToString

    Given I create a Grid with structure
    """
    1 2 3 4
    3 2 4 1
    2 3 4 1
    4 3 2 1
    """
    Then The String representation should look like

    """
    .-------.
    |1 2|3 4|
    |3 2|4 1|
    |-------|
    |2 3|4 1|
    |4 3|2 1|
    .-------.
    """