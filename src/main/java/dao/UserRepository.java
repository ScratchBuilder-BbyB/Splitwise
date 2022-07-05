package dao;

import domain.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User, String, String>{

  private static final Map<String, User> map = new HashMap<>();

  public User save(User user) {
    map.putIfAbsent(user.getName(), user);
    return map.get(user.getName());
  }

  public User getById(String name) {
    return map.getOrDefault(name, null);
  }

  @Override
  public User update(User user) {
    return null;
  }

  @Override
  public List<User> getAllByFilter(String s) {
    return null;
  }
}
