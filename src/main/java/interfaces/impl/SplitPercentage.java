package interfaces.impl;

import domain.OweDetailsWrapper;
import interfaces.Command;
import interfaces.SplitWise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitPercentage implements Command<SplitWise> {

  @Override
  public void execute(String command, SplitWise instance) {
    //    EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
    String[] args = splitCommand(command);
    String lendUser = args[1];
    double lendAmount = Double.parseDouble(args[2]);
    int noOfOwedUsers = Integer.parseInt(args[3]);
    List<String> owedUserName = Arrays.stream(Arrays.copyOfRange(args, 4, 4 + noOfOwedUsers)).collect(
        Collectors.toList());
    List<Double> splitPercentages = Arrays.stream(
        Arrays.copyOfRange(args, 4 + noOfOwedUsers + 1, args.length)).map(Double::parseDouble).collect(
        Collectors.toList());

    List<Double> splitAmounts = new ArrayList<>();
    splitPercentages.forEach(percent -> splitAmounts.add(lendAmount * (percent / 100)));
    owedUserName.forEach(instance::register);
    instance.register(lendUser);
    instance.createAccount(lendUser, owedUserName);
    List<OweDetailsWrapper> oweDetailsWrappers = new ArrayList<>();

    for(int i = 0; i < owedUserName.size(); i++){
      oweDetailsWrappers.add(new OweDetailsWrapper(owedUserName.get(i), splitAmounts.get(i)));
    }

    splitAmount(instance, lendUser, oweDetailsWrappers);
  }
}
