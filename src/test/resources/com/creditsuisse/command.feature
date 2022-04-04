Feature: Take input from IO for canvas operations

  Scenario Outline: User can input the following commands to manipulate the canvas
    Given user input string "<input>"
    Then command parser will parse the string into "<command>" and get the correct <parameter Count> as "<parameters>"

    Examples:
      | input         | command | parameter Count | parameters  |
      | C w h         | C       | 2               | w,h         |
      | L x1 y1 x2 y2 | L       | 4               | x1,y1,x2,y2 |
      | R x1 y1 x2 y2 | L       | 4               | x1,y1,x2,y2 |
      | B x y c       | L       | 3               | x,y,c       |
      | Q             | Q       | 0               |             |