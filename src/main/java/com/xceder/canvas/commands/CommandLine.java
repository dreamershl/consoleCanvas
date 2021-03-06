package com.xceder.canvas.commands;

import com.xceder.canvas.Canvas;
import com.xceder.canvas.Point;
import java.util.regex.Pattern;

public class CommandLine extends CommandBase {
  protected Point from;
  protected Point to;

  protected CommandLine() {
    this(ACTION.LINE);
  }

  protected CommandLine(ACTION action) {
    super(action, Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s*"));
  }

  @Override
  public void parseParameters(String parameters) throws Exception {
    var list = parse(parameters);

    from = new Point(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)));
    to = new Point(Integer.parseInt(list.get(2)), Integer.parseInt(list.get(3)));
  }

  @Override
  public String getParameters() {
    return String.format("%s;%s", from.toString(), to.toString());
  }

  @Override
  public void execute(Canvas canvas) {
    canvas.drawLine(from.getAxisX() - 1, from.getAxisY() - 1, to.getAxisX() - 1, to.getAxisY() - 1);
  }
}
