package service;

import enums.CommandType;
import interfaces.Command;
import interfaces.impl.ShowCommand;
import interfaces.impl.SplitEqualCommand;
import interfaces.impl.SplitExactCommand;
import interfaces.impl.SplitPercentage;

public class CommandExecutorFactory {

  private final SplitEqualCommand splitEqualCommand;
  private final ShowCommand showCommand;
  private final SplitExactCommand splitExactCommand;
  private final SplitPercentage splitPercentage;

  public CommandExecutorFactory(SplitEqualCommand splitEqualCommand,
      ShowCommand showCommand, SplitExactCommand splitExactCommand,
      SplitPercentage splitPercentage) {
    this.splitEqualCommand = splitEqualCommand;
    this.showCommand = showCommand;
    this.splitExactCommand = splitExactCommand;
    this.splitPercentage = splitPercentage;
  }

  public Command getCommand(CommandType commandType) {
    switch (commandType) {
      case EQUAL:
        return splitEqualCommand;

      case SHOW:
        return showCommand;

      case EXACT:
        return splitExactCommand;

      case PERCENT:
        return splitPercentage;

      default:
        return null;
    }
  }
}
