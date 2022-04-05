package com.xceder.canvas.commands;

import java.util.regex.Pattern;
import javax.inject.Singleton;

@Singleton
public class CommandFactory {
  private final Pattern pattern = Pattern.compile("(\\w)\\s?(.*)");

  public Command parse(String input) throws Exception {
    var matches = pattern.matcher(input);

    if (!matches.matches()) {
      throw new Exception("Invalid command line:" + input);
    }

    var commandKey = matches.group(1);
    var parameters = matches.group(2);

    Command result;

    var action = ACTION.parse(commandKey.toUpperCase());

    switch (action) {
      case CREATE:
        result = new CommandCreateCanvas();
        break;
      case BRUSH:
        result = new CommandBrush();
        break;
      case LINE:
        result = new CommandLine();
        break;
      case RECT:
        result = new CommandRect();
        break;
      case QUIT:
        result = new CommandQuit();
        break;

      default:
        throw new Exception("unexpected action:" + action);
    }

    result.parseParameters(parameters.trim());

    return result;
  }
}
