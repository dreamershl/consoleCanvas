package com.xceder.canvas.commands;

import com.xceder.canvas.Canvas;

public interface Command {
  void parseParameters(String parameters) throws Exception;

  String getParameters();

  ACTION getAction();

  void execute(Canvas canvas);
}
