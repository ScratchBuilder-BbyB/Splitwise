package interfaces.impl;

import domain.Account;
import interfaces.Command;
import interfaces.SplitWise;
import java.util.List;
import java.util.Objects;

public class ShowCommand implements Command<SplitWise> {

  @Override
  public void execute(String command, SplitWise instance) {
    String[] args = splitCommand(command);
    String userName = null;
    if(args.length == 2){
      userName = args[1];
    }
    List<Account> userAccounts = instance.getUserAccounts(userName);
    if(userAccounts.isEmpty()){
      System.out.println("No balances");
    }else{
      String finalUserName = userName;
      userAccounts.forEach(account -> {
        if(Objects.isNull(finalUserName) || account.getOwedUser().getName().equals(finalUserName)){
          System.out.println(String.format("%s owes %s : %s", account.getOwedUser().getName(), account.getLendUser().getName(), account.getOweDetails().getCurrentAmount()));
        }
      });
    }
  }
}
