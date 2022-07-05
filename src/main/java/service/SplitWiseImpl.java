package service;

import dao.AccountRepository;
import dao.UserRepository;
import domain.Account;
import domain.User;
import interfaces.SplitWise;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitWiseImpl implements SplitWise {

  private final UserRepository userRepository;
  private final AccountRepository accountRepository;

  public SplitWiseImpl(UserRepository userRepository, AccountRepository accountRepository) {
    this.userRepository = userRepository;
    this.accountRepository = accountRepository;
  }

  public void register(String... userName) {
    Arrays.stream(userName)
        .forEach(name -> userRepository.save(new User(name, name.concat("@gmail.com"), "")));
  }

  public Account getAccount(String accountId) {
    return accountRepository.getById(accountId);
  }

  @Override
  public List<Account> createAccount(String currentSerId, List<String> otherUsers) {
    return otherUsers.stream().map(otherName -> accountRepository.save(
        new Account(userRepository.getById(currentSerId), userRepository.getById(otherName)))).collect(
        Collectors.toList());

  }

  @Override
  public void updateAccount(Account account) {
    accountRepository.update(account);
  }

  @Override
  public List<Account> getUserAccounts(String userName) {
    return accountRepository.getAllByFilter(userName);
  }
}
