package com.creditsuisse.canvas;

import com.creditsuisse.canvas.commands.ACTION;
import com.creditsuisse.canvas.commands.Command;
import com.creditsuisse.canvas.commands.CommandFactory;
import java.util.Scanner;

public class CanvasApp {
  public static void main(String[] args) {
    printHelp();

    Canvas canvas = new Canvas(0, 0, 'x');
    CommandFactory commandFactory = new CommandFactory();
    Scanner console = new Scanner(System.in);

    while (true) {
      String line = console.nextLine().trim();

      try {
        Command command = commandFactory.parse(line);

        if (command.getAction() == ACTION.QUIT) {
          break;
        } else {
          canvas.addCommand(command);
          canvas.render();
        }

      } catch (Exception e) {
        System.out.println("Invalid command:" + line);
        System.out.println("Error:" + e.getMessage());

        printHelp();
      }
    }
  }

  private static void printHelp() {
    String help = """
        Command 		Description
        C w h           Should create a new canvas of width w and height h.
        L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                        horizontal or vertical lines are supported. Horizontal and vertical lines
                        will be drawn using the 'x' character.
        R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                        lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                        using the 'x' character.
        B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                        behavior of this is the same as that of the "bucket fill" tool in paint
                        programs.
        Q               Should quit the program.
        """;

    System.out.println(help);
  }
}