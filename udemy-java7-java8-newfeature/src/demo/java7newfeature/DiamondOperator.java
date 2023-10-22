package demo.java7newfeature;

import java.util.HashMap;
import java.util.Map;

public class DiamondOperator {
  public static void main(String[] args) {
    beforeJava7();
    System.out.println("--------------------------------------");
    withJava7();
  }

  private static void beforeJava7() {
    Map<String, Integer> inputMap = new HashMap<String, Integer>();
    inputMap.put("Monday", 1);
    inputMap.put("Tuesday", 2);
    inputMap.put("Wednesday", 3);
    inputMap.put("Thursday", 4);
    inputMap.put("Friday", 5);
    inputMap.put("Saturday", 6);
    inputMap.put("Sunday", 7);

    for (Map.Entry<String, Integer> e : inputMap.entrySet()) {
      System.out.println("The value for the key: " + e.getKey() + " is : " + e.getValue());
    }
  }

  private static void withJava7() {
    Map<String, Integer> inputMap = new HashMap<>();
    inputMap.put("January", 1);
    inputMap.put("February", 2);
    inputMap.put("March", 3);
    inputMap.put("April", 4);
    inputMap.put("May", 5);
    inputMap.put("June", 6);
    inputMap.put("July", 7);
    inputMap.put("August", 8);
    inputMap.put("September", 9);
    inputMap.put("October", 10);
    inputMap.put("November", 11);
    inputMap.put("December", 12);

    for (Map.Entry<String, Integer> e : inputMap.entrySet()) {
      System.out.println("The value for the key: " + e.getKey() + " is : " + e.getValue());
    }
  }
}
