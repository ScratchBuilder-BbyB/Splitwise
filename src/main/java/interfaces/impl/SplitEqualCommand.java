package interfaces.impl;

import domain.Account;
import domain.OweDetails;
import domain.OweDetailsWrapper;
import domain.User;
import interfaces.Command;
import interfaces.SplitWise;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.IDGenerator;

public class SplitEqualCommand implements Command<SplitWise> {

  @Override
  public void execute(String command, SplitWise splitWise) {
    String[] args = splitCommand(command);
    List<String> userNames = getUserNames(3, args);
    userNames.forEach(splitWise::register);

    String currentSerId = args[1];
    List<String> otherUsers = getUserNames(3, args).stream().filter(name -> !name.equals(currentSerId)).collect(
        Collectors.toList());
    splitWise.createAccount(currentSerId, otherUsers);
    double amountPerHead = Double.parseDouble(args[2]) / Integer.parseInt(args[3]);
    List<OweDetailsWrapper> oweDetailsWrappers = otherUsers.stream().map(name -> new OweDetailsWrapper(name, amountPerHead)).collect(
        Collectors.toList());
    splitAmount(splitWise, currentSerId, oweDetailsWrappers);
  }

  private List<String> getUserNames(int index, String[] args) {
    int numberOfUsers = Integer.parseInt(args[3]);
    List<String> userNames = new ArrayList<>();
    while (numberOfUsers-- > 0){
      index++;
      userNames.add(args[index]);
    }
    return userNames;
  }
}
