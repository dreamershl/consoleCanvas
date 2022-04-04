package com.creditsuisse.canvas.commands;

import com.creditsuisse.canvas.Canvas;

public class CommandRect extends CommandLine {
  protected CommandRect() {
    super(ACTION.RECT);
  }

  @Override
  public void execute(Canvas canvas) {
    var fromX = from.getAxisX() - 1;
    var fromY = from.getAxisY() - 1;
    var toX = to.getAxisX() - 1;
    var toY = to.getAxisY() - 1;

    canvas.drawRect(fromX, fromY, toX, toY);
  }
}
