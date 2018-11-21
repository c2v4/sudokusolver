Feature: GridSimplify

  @ignored
  Scenario: Simplifying 4x4 grid

    Given I create a Grid with structure
    """
    1 . . .
    . 2 . .
    . . 3 .
    . . . 4
    """
    When <some action>
    Then <some expectation>