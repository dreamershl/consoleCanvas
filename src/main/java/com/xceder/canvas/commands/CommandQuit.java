package com.xceder.canvas.commands;

import com.xceder.canvas.Canvas;
import java.util.regex.Pattern;

public class CommandQuit extends CommandBase {
  protected CommandQuit() {
    super(ACTION.QUIT, Pattern.compile("(\\s*)"));
  }

  @Override
  public void parseParameters(String parameters) throws Exception {
    parse(parameters);
  }

  @Override
  public String getParameters() {
    return "";
  }

  @Override
  public void execute(Canvas canvas) {
    throw new IllegalStateException("QUIT should not be executed");
  }
}
