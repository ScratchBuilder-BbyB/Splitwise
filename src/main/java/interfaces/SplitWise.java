package interfaces;

import domain.Account;
import java.util.List;

public interface SplitWise {

  void register(String... userName);

  Account getAccount(String accountId);

  List<Account> createAccount(String currentSerId, List<String> otherUsers);

  void updateAccount(Account account);

  List<Account> getUserAccounts(String userName);
}
