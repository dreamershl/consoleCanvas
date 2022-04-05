package com.xceder.canvas;

import com.xceder.canvas.commands.ACTION;
import com.xceder.canvas.commands.Command;
import com.xceder.canvas.commands.CommandFactory;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;

@ScenarioScoped
public class CommandSteps {
  private final CommandFactory commandFactory;
  private final List<Command> commandList;

  @Inject
  public CommandSteps(CommandFactory commandFactory,
                      List<Command> commandList) {
    this.commandFactory = commandFactory;
    this.commandList = commandList;
  }

  @When("the command string is {string}")
  public void theInputStringIs(String commandLine) throws Exception {
    var command = commandFactory.parse(commandLine);
    commandList.add(command);
  }

  @Then("command parser will parse it into {string} with {string}")
  public void commandParserWillParseItIntoWith(String commandName, String parameters) {
    var action = ACTION.valueOf(commandName);
    var lastCommand = commandList.get(commandList.size() - 1);
    Assertions.assertEquals(action, lastCommand.getAction());
    Assertions.assertEquals(parameters, lastCommand.getParameters());
  }
}
