package interfaces.impl;

import domain.OweDetailsWrapper;
import interfaces.Command;
import interfaces.SplitWise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitExactCommand implements Command<SplitWise> {

  @Override
  public void execute(String command, SplitWise instance) {
//    EXPENSE u1 1250 2 u2 u3 EXACT 370 880
    String[] args = splitCommand(command);
    String lendUserName = args[1];
    int noOfOwedUsers = Integer.parseInt(args[3]);
    List<String> owedUserNames = Arrays.stream(Arrays.copyOfRange(args, 4, 4 + noOfOwedUsers)).collect(
        Collectors.toList());
    List<Double> owedUserSplits = Arrays.stream(
        Arrays.copyOfRange(args, 4 + noOfOwedUsers + 1, args.length)).map(Double::parseDouble).collect(
        Collectors.toList());

    owedUserNames.forEach(instance::register);
    instance.register(lendUserName);
    instance.createAccount(lendUserName, owedUserNames);

    List<OweDetailsWrapper> oweDetailsWrappers = new ArrayList<>();
    for(int i = 0; i < owedUserSplits.size(); i++){
      oweDetailsWrappers.add(new OweDetailsWrapper(owedUserNames.get(i), owedUserSplits.get(i)));
    }

    splitAmount(instance, lendUserName, oweDetailsWrappers);


  }
}
