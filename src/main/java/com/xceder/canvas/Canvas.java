package com.xceder.canvas;

import com.xceder.canvas.commands.Command;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Canvas {
  private final List<Command> commandList = new ArrayList<>();
  private final char pixel;

  private int height;
  private int width;
  private char[][] buffer;

  public Canvas(int width, int height, char pixel) {
    this.pixel = pixel;
    this.reset(width, height);
  }

  public void addCommand(Command command) {
    commandList.add(command);
  }

  private int convertToCanvasAxisX(int point) {
    var result = point;

    if (result < 0) {
      result = 0;
    } else if (result >= width) {
      result = width - 1;
    }

    return result;
  }

  private int convertToCanvasAxisY(int point) {
    var result = point;

    if (result < 0) {
      result = 0;
    } else if (result >= height) {
      result = height - 1;
    }

    return result;
  }

  private char getPixel(int pointX, int pointY) {
    pointY = convertToCanvasAxisY(pointY);
    pointX = convertToCanvasAxisX(pointX);

    char result = 0;
    if (height > 0 && width > 0) {
      result = buffer[pointY][pointX];
    }

    return result;
  }

  private void setPixel(int pointX, int pointY, char color) {
    pointY = convertToCanvasAxisY(pointY);
    pointX = convertToCanvasAxisX(pointX);

    if (height > 0 && width > 0) {
      buffer[pointY][pointX] = color;
    }
  }

  public void fill(int pointX, int pointY, char color) {
    int pixel = getPixel(pointX, pointY);

    // A* search
    if (pixel == ' ') {
      setPixel(pointX, pointY, color);
      fill(pointX + 1, pointY, color);
      fill(pointX - 1, pointY, color);
      fill(pointX, pointY + 1, color);
      fill(pointX, pointY - 1, color);
    }
  }

  public void drawRect(int fromX, int fromY, int toX, int toY) {
    for (int row = fromY; row <= toY; row++) {
      for (int col = fromX; col <= toX; col++) {
        if ((row == fromY || row == toY) || (col == fromX || col == toX)) {
          setPixel(col, row, pixel);
        }
      }
    }
  }

  public void drawLine(int fromX, int fromY, int toX, int toY) {
    setPixel(fromX, fromY, pixel);
    setPixel(toX, toY, pixel);

    int midX = (fromX + toX) >> 1;
    int midY = (fromY + toY) >> 1;

    var isSameMidPoint = (fromX == midX && fromY == midY) || (toX == midX && toY == midY);

    if (!isSameMidPoint) {
      setPixel(midX, midY, pixel);

      drawLine(fromX, fromY, midX, midY);
      drawLine(midX, midY, toX, toY);
    }
  }

  public void reset(int width, int height) {
    this.height = height;
    this.width = width;
    clearBuffer();
  }

  public void clearBuffer() {
    this.buffer = new char[height][width];

    for (var row : buffer) {
      Arrays.fill(row, ' ');
    }
  }

  public char[][] render() {
    for (var command : commandList) {
      command.execute(this);
    }
    return buffer;
  }
}
