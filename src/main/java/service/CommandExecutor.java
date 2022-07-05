package service;

import enums.CommandType;
import interfaces.SplitWise;

public class CommandExecutor {

  private final SplitWise splitWise;
  private final CommandExecutorFactory commandExecutorFactory;


  public CommandExecutor(SplitWise splitWise, CommandExecutorFactory commandExecutorFactory) {
    this.splitWise = splitWise;
    this.commandExecutorFactory = commandExecutorFactory;
  }

  public void processCommand(String command) {
    CommandType commandType = CommandType.getCommandTypeFrom(command);
    commandExecutorFactory.getCommand(commandType).execute(command, splitWise);
  }
}
