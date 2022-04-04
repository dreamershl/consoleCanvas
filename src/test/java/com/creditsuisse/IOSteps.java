package com.creditsuisse;

import com.creditsuisse.canvas.commands.ACTION;
import com.creditsuisse.canvas.commands.Command;
import com.creditsuisse.canvas.commands.CommandFactory;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.EnumMap;
import java.util.Map;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;

@ScenarioScoped
public class IOSteps {
  private final CommandFactory commandFactory;
  private final Map<ACTION, Command> commandMap = new EnumMap<>(ACTION.class);

  @Inject
  public IOSteps(CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  @When("the input string is {string}")
  public void theInputStringIs(String input) throws Exception {
    var command = commandFactory.parse(input);
    commandMap.put(command.getAction(), command);
  }

  @Then("command parser will parse it into {string} with {string}")
  public void commandParserWillParseItIntoWith(String commandName, String parameters) {
    var action = ACTION.valueOf(commandName);

    Assertions.assertEquals(parameters, commandMap.get(action).getParameters());
  }
}
