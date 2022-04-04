package com.creditsuisse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class IOSteps {
    @Given("user input string {string}")
    public void userInputString(String input) {

    }


    @Then("command parser will parse the string into {string} and get the correct <parameterCount> as {string}")
    public void commandParserWillParseTheStringIntoAndGetTheCorrectParameterCountAs(String arg0, String arg1) {

    }

    @Then("command parser will parse the string into {string} and get the correct {int} as {string}")
    public void commandParserWillParseTheStringIntoAndGetTheCorrectAs(String command, int count, String parameterString) {

    }
}
