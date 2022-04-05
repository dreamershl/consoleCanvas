package com.creditsuisse;

import com.creditsuisse.canvas.commands.Command;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

public class TestModule extends AbstractModule {

  @Singleton
  @Provides
  public List<Command> provideCommandMap() {
    return new ArrayList<>();
  }
}
