package com.creditsuisse;

import com.creditsuisse.canvas.commands.ACTION;
import com.creditsuisse.canvas.commands.CommandFactory;
import io.cucumber.java.en.Given;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;

public class IOSteps {
  private final CommandFactory commandFactory;

  @Inject
  public IOSteps(CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  @Given("command parser will parse the string {string} into {string} with {string}")
  public void commandParserWillParseTheStringIntoWith(String input,
                                                      String commandName,
                                                      String parameterString) throws Exception {

    var command = commandFactory.parse(input);

    Assertions.assertNotNull(command);
    Assertions.assertEquals(ACTION.valueOf(commandName), command.getAction());
    Assertions.assertEquals(parameterString, command.getParameters());
  }
}
