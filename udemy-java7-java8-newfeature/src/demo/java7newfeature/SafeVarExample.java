package demo.java7newfeature;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVarExample {
  public static void main(String[] args) {
    sum(1);
    sum(1, 2);
    sum(1, 2, 3);
    SafeVarExample obj = new SafeVarExample();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    list1.add("Easy");
    list2.add("Bytes");
    list3.add("Java 7");
    obj.print(list1, list2, list3);
  }

  @Deprecated
  public static void printName(String name) {
    System.out.println("Name " + name);
  }

  @SafeVarargs
  public final void print(List<String>... messages) {
//    Object[] arr = messages;
//    List<Integer> intList = new ArrayList<Integer>();
//    intList.add(1606);
//    arr[0] = intList;
    String firstElement = messages[0].get(0);
    System.out.println(firstElement);
  }

  private static void sum(int... nums) {
    System.out.println(Arrays.toString(nums));
    int sum = 0;
    for (int num : nums) {
      sum = sum += num;
    }
    System.out.println("The total sum for the given input is : " + sum);
  }
}
