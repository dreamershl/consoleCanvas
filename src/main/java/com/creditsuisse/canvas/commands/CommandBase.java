package com.creditsuisse.canvas.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class CommandBase implements Command {
  private final ACTION action;
  private final Pattern parameterRegPattern;

  protected CommandBase(ACTION action, Pattern parameterRegPattern) {
    this.action = action;
    this.parameterRegPattern = parameterRegPattern;
  }

  protected List<String> parse(String parameters) throws Exception {
    var matches = parameterRegPattern.matcher(parameters);

    if (!matches.matches()) {
      throw new Exception("Invalid parameters:" + parameters);
    }

    List<String> matchList = new ArrayList<>();

    for (int index = 1; index <= matches.groupCount(); index++) {
      matchList.add(matches.group(index));
    }

    return matchList;
  }

  @Override
  public ACTION getAction() {
    return action;
  }
}
