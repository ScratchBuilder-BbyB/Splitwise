package dao;

import domain.Account;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class AccountRepository implements Repository<Account, String, String>{
  private static final Map<String, Account> map = new HashMap<>();

  @Override
  public Account save(Account account) {
    map.putIfAbsent(account.getId(), account);
    return map.get(account.getId());
  }

  @Override
  public Account getById(String s) {
    return map.getOrDefault(s, null);
  }

  @Override
  public Account update(Account account) {
    map.computeIfPresent(account.getId(), (a, b) -> map.put(a, account));
    return account;
  }

  @Override
  public List<Account> getAllByFilter(String userName) {

    return map.values().stream().filter(account -> (Objects.isNull(userName) || account.getId().contains(userName)) && account.getOweDetails().getCurrentAmount() > 0).collect(Collectors.toList());
  }

}
