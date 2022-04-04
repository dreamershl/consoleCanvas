package com.creditsuisse.canvas.commands;

public enum ACTION {
  UNKNOWN(""),
  CREATE("C"),
  BRUSH("B"),
  LINE("L"),
  RECT("R"),
  QUIT("Q");

  private final String key;

  ACTION(String key) {
    this.key = key;
  }

  public static ACTION parse(String key) {
    ACTION result = UNKNOWN;
    for (var action : ACTION.values()) {
      if (action.key.equals(key)) {
        result = action;
      }
    }

    return result;
  }
}
