package com.creditsuisse;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;

public class CucumberInjectorSource implements InjectorSource {
  private final Injector injector = Guice.createInjector(CucumberModules.createScenarioModule());

  @Override
  public Injector getInjector() {
    return injector;
  }
}
