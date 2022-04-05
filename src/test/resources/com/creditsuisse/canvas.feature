Feature: Canvas need provide the various drawing actions

  @Isolated
  Scenario Outline: Canvas can render the drawing action properly
    When the command string is "<input>"
    Then canvas buffer MD5 hash HEX should be "<MD5>"

    Examples:
      | input       | MD5                              |
      | C 20 4      | 02E0130D98C85D6B09704BB0496E84BF |
      | L 1 2 6 2   | 8876EFDD3F2B6C66C4F2F108293914DD |
      | L 6 3 6 4   | 843674DEB5F637C2C2C60A6446AEC3B4 |
      | R 14 1 18 3 | A5AE7EDA6FB1164899F10E27C3246875 |
      | B 10 3 o    | 324F20CE4A7D452347F56CF5DA5B83DA |