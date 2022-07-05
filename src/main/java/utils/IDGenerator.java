package utils;

import com.sun.xml.internal.bind.v2.model.core.ID;
import domain.User;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IDGenerator {
  private static int ID = 0;
    public static int getNextId(){
      ID++;
      return ID;
    }

    public static String getAccountId(String u1, String u2){
      List<String> names = Arrays.asList(u1, u2);
      Collections.sort(names);
      return names.toString();
    }
}
