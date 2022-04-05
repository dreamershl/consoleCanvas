package com.xceder.canvas.commands;

import com.xceder.canvas.Canvas;
import com.xceder.canvas.Point;
import java.util.regex.Pattern;

public class CommandBrush extends CommandBase {
  private Point point;
  private char color;

  public CommandBrush() {
    super(ACTION.BRUSH, Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\w)\\s*"));
  }

  @Override
  public void parseParameters(String parameters) throws Exception {
    var list = parse(parameters);

    var axisX = Integer.parseInt(list.get(0));
    var axisY = Integer.parseInt(list.get(1));
    point = new Point(axisX, axisY);
    color = list.get(2).toCharArray()[0];
  }

  @Override
  public String getParameters() {
    return String.format("%s,%c", point.toString(), color);
  }

  @Override
  public void execute(Canvas canvas) {
    canvas.fill(point.getAxisX() - 1, point.getAxisY() - 1, color);
  }
}
