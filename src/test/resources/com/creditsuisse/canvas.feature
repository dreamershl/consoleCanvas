Feature: Canvas operations

  Scenario Outline: User can input the following commands to manipulate the canvas
    Given command parser will parse the string "<input>" into "<command>" with "<parameters>"

    Examples:
      | input       | command | parameters                                        |
      | C 20 4      | CREATE  | 20,4                                              |
      | L 1 2 6 2   | LINE    | Point(axisX=1, axisY=2);Point(axisX=6, axisY=2)   |
      | L 6 3 6 4   | LINE    | Point(axisX=6, axisY=3);Point(axisX=6, axisY=4)   |
      | R 14 1 18 3 | RECT    | Point(axisX=14, axisY=1);Point(axisX=18, axisY=3) |
      | B 10 3 o    | BRUSH   | Point(axisX=10, axisY=3),o                        |
      | Q           | QUIT    |                                                   |