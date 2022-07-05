package interfaces;

import domain.Account;
import domain.OweDetails;
import domain.OweDetailsWrapper;
import domain.User;
import java.util.List;
import utils.IDGenerator;

public interface Command <T>{
  void execute(String command, T instance);
  default String[] splitCommand(String command) {
    return command.split(" ");
  }

  default void splitAmount(SplitWise splitWise, String lendUserName, List<OweDetailsWrapper> oweDetailsWrappers) {
    oweDetailsWrappers.forEach(wrapper -> {
      Account account = splitWise.getAccount(
          IDGenerator.getAccountId(wrapper.getUserName(), lendUserName));
      User lendUser = account.getLendUser();
      User owedUser = account.getOwedUser();
      OweDetails oweDetails = account.getOweDetails();
      double currentAmount = oweDetails.getCurrentAmount();
      oweDetails.setPreviousAmount(currentAmount);
      if(lendUser.getName().equals(lendUserName)){
        oweDetails.setCurrentAmount(currentAmount + wrapper.getAmount());
      }else{
        oweDetails.setCurrentAmount(currentAmount - wrapper.getAmount());
      }

      if(oweDetails.getCurrentAmount() < 0){
        User temp = lendUser;
        lendUser = owedUser;
        owedUser = temp;
        oweDetails.setCurrentAmount(Math.abs(oweDetails.getCurrentAmount()));
      }
      account.setLendUser(lendUser);
      account.setOwedUser(owedUser);
      splitWise.updateAccount(account);
    });

    commandExecuted();
  }

  default  void commandExecuted(){
    System.out.println("------------------------------------------------------------------------------------------------------------------------");
  }
}
