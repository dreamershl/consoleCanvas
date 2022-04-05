package com.xceder.canvas;

import com.google.common.io.BaseEncoding;
import com.xceder.canvas.commands.Command;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;

@ScenarioScoped
public class CanvasSteps {
  private final List<Command> commandList;
  private final MessageDigest digest = MessageDigest.getInstance("MD5");

  @Inject
  public CanvasSteps(List<Command> commandList) throws NoSuchAlgorithmException {
    this.commandList = commandList;
  }

  @Then("canvas buffer MD5 hash HEX should be {string}")
  public void canvasBufferShouldBe(String bufferHash) throws NoSuchAlgorithmException {
    Canvas canvas = new Canvas(0, 0, 'x');
    commandList.forEach(canvas::addCommand);
    char[][] buff = canvas.render();

    StringBuilder builder = new StringBuilder();

    for (var row : buff) {
      builder.append(row);
    }

    byte[] hash = digest.digest(builder.toString().getBytes(StandardCharsets.UTF_8));
    Assertions.assertEquals(bufferHash, BaseEncoding.base16().encode(hash));
  }
}
