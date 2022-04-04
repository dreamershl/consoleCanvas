package com.creditsuisse.canvas.commands;

import com.creditsuisse.canvas.Canvas;

public interface Command {
  void parseParameters(String parameters) throws Exception;

  String getParameters();

  ACTION getAction();

  void execute(Canvas canvas);
}
