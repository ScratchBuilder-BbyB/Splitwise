package enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum CommandType {
  EQUAL("EQUAL"),
  EXACT("EXACT"),
  PERCENT("PERCENT"),
  SHOW("SHOW");

  private final String id;
  private static final Map<String, CommandType> map = new HashMap<>();

    CommandType(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public static CommandType getCommandTypeFrom(String command){
    List<CommandType> collect = Arrays.stream(values()).filter(type -> command.contains(type.id))
        .collect(Collectors.toList());
    return !collect.isEmpty() ? collect.get(0) : null;
  }

  static {
    Arrays.stream(values()).forEach(value -> map.put(value.getId(), value));
  }
}
