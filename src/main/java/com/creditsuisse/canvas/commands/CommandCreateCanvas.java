package com.creditsuisse.canvas.commands;

import com.creditsuisse.canvas.Canvas;
import java.util.regex.Pattern;

public class CommandCreateCanvas extends CommandBase {
  private int width;
  private int height;

  protected CommandCreateCanvas() {
    super(ACTION.CREATE, Pattern.compile("(\\d+)\\s+(\\d+)\\s*"));
  }

  @Override
  public void parseParameters(String parameters) throws Exception {
    var list = parse(parameters);

    width = Integer.parseInt(list.get(0));
    height = Integer.parseInt(list.get(1));
  }

  @Override
  public String getParameters() {
    return String.format("%d,%d", width, height);
  }

  @Override
  public void execute(Canvas canvas) {
    canvas.reset(width, height);
  }
}
