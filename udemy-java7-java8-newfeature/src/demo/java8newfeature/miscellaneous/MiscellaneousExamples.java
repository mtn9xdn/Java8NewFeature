package demo.java8newfeature.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;

public class MiscellaneousExamples {
  /**
   * List -> replaceAll() , sort()
   * Iterator -> forEachRemaining()
   * Iterable -> forEach(), spliterator()
   * Collection -> reversed(), thenComparing(), naturalOrder(), reverseOrder(), nullsFirst(), nullsLast()
   * Arrays -> setAll(), parallelSetAll(), paralllelSort(), parallelPrefix()
   * String -> join()
   * Math -> [add][subtract][multiply][increment][decrement][negate]Exact, tolntExact, floorMod, floorDiv and nextDown.
   * Number -> sum, min and max static methods in Short, Integer, Long, Float and Double. Etc.
   * Boolean -> logicalAnd(), logicalOr(), logicalXor()
   * Objects -> isNull(), nonNull().
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("-------listReplaceAll-------");
    listReplaceAll();
    System.out.println("-------listSort-------");
    listSort();
    System.out.println("-------spliterator-------");
    spliterator();
    System.out.println("-------forEachRemaining-------");
    forEachRemaining();
    System.out.println("-------forEach-------");
    forEach();
    System.out.println("-------mapEnhancements-------");
    mapEnhancements();
    System.out.println("-------stringJoin-------");
    stringJoin();
    System.out.println("-------arrayMethods-------");
    arrayMethods();
    System.out.println("-------numberMethods-------");
    numberMethods();
    System.out.println("-------mathMethods-------");
    mathMethods();
    System.out.println("-------objectsNullCheck-------");
    objectsNullCheck();
    System.out.println("-------booleanMethods-------");
    booleanMethods();
  }

  private static void listReplaceAll() {
    List<String> mobileList = new ArrayList<>();
    mobileList.add("Iphone");
    mobileList.add("Samsung");
    mobileList.add("Sony");
    mobileList.add("Oppo");
    mobileList.add("Xiaomi");
    mobileList.add("LG");
    System.out.println("Before List : " + mobileList);

    mobileList.replaceAll(element -> element.toUpperCase());
    System.out.println("List After Replace All : " + mobileList);
  }

  private static void listSort() {
    List<String> mobileList = new ArrayList<>();
    mobileList.add("Iphone");
    mobileList.add("Samsung");
    mobileList.add("Sony");
    mobileList.add("Oppo");
    mobileList.add("Xiaomi");
    mobileList.add("LG");
    System.out.println("Before List : " + mobileList);

    mobileList.sort(Comparator.naturalOrder());
    System.out.println("List After Sort : " + mobileList);
  }

  private static void spliterator() {
    List<String> mobileList = new ArrayList<>();
    mobileList.add("Iphone");
    mobileList.add("Samsung");
    mobileList.add("Sony");
    mobileList.add("Oppo");
    mobileList.add("Xiaomi");
    mobileList.add("LG");
    System.out.println("Before List : " + mobileList);
    System.out.println("spliterator :");
    ArrayList<String> newList = new ArrayList<>();
    Spliterator<String> splitr = mobileList.spliterator();
    while (splitr.tryAdvance((value) -> newList.add(value.toUpperCase()))) ;

    Spliterator<String> newSplitr = newList.spliterator();
    while (newSplitr.tryAdvance(System.out::println)) ;
  }

  private static void forEachRemaining() {
    List<String> mobileList = new ArrayList<>();
    mobileList.add("Iphone");
    mobileList.add("Samsung");
    mobileList.add("Sony");
    mobileList.add("Oppo");
    mobileList.add("Xiaomi");
    mobileList.add("LG");
    System.out.println("Before List : " + mobileList);
    System.out.println("forEachRemaining :");
    mobileList.iterator()
            .forEachRemaining(System.out::println);
  }

  private static void forEach() {
    List<String> mobileList = new ArrayList<>();
    mobileList.add("Iphone");
    mobileList.add("Samsung");
    mobileList.add("Sony");
    mobileList.add("Oppo");
    mobileList.add("Xiaomi");
    mobileList.add("LG");
    System.out.println("forEach");
    mobileList.forEach(System.out::println);
  }

  private static void mapEnhancements() {
    Map<String, String> map = new HashMap<>();
    map.put("India", "Delhi");
    map.put("USA", "Washington");
    map.put("China", "Beijing");
    map.put("Germany", "Berlin");
    map.put("Endland", "London");
    map.put("Australia", "Canberra");

    map.forEach((country, capital) -> System.out.println("The capital of : " + country + " is " + capital));
    System.out.println("--------comparingByKey---------");
    map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(System.out::println);
    System.out.println("--------comparingByValue---------");
    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(System.out::println);
    System.out.println("--------getOrDefault---------");
    System.out.println(map.getOrDefault("Russia", "No Data Present"));
    map.computeIfAbsent("Spain", name -> "Madrid");
    map.computeIfPresent("USA", (k, v) -> "Washington DC");
    System.out.println("--------sorted---------");
    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(System.out::println);
  }

  private static void stringJoin() {
    String departments = String.join(", ", "Supply", "HR", "Sales");
    System.out.println("Tham Khảo Class StreamOperations");
    System.out.println(departments);
  }

  private static void arrayMethods() {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    System.out.println("------Array * 2-------");
    Arrays.setAll(array, element -> {
      return array[element] = array[element] * 2;
    });
    System.out.println(Arrays.toString(array));

    int[] unsortedArr = {3, 78, 7, 91, 20, 1, 8, 54};
    Arrays.parallelSort(unsortedArr);
    System.out.println("------parallelSort-------");
    System.out.println(Arrays.toString(unsortedArr));

    Arrays.parallelPrefix(array, (first, second) -> {
      return first + second;
    });
    System.out.println("------parallelPrefix-------");
    System.out.println(Arrays.toString(array));
  }

  private static void numberMethods() {
    int sum = Integer.sum(234, 4565);
    int max = Integer.max(234, 4565);
    int min = Integer.min(234, 4565);
    System.out.println("Sum : " + sum);
    System.out.println("Max : " + max);
    System.out.println("Min : " + min);
  }

  private static void mathMethods() {
    long sum = Math.addExact(1234, 45456);
    long sub = Math.subtractExact(1234, 45456);
    long mul = Math.multiplyExact(1234, 45456);
    long inc = Math.incrementExact(45456);
    long dec = Math.decrementExact(1234);
    long neg = Math.negateExact(1234);
    long toInt = Math.toIntExact(12345676);
    long floorDiv = Math.floorDiv(1234, 45456);
    long floorMod = Math.floorMod(1234, 45456);
    float nextDown = Math.nextDown(12);
    System.out.println("Sum " + sum);
    System.out.println("Sub " + sub);
    System.out.println("Mul " + mul);
    System.out.println("Inc " + inc);
    System.out.println("Dec " + dec);
    System.out.println("Neg " + neg);
    System.out.println("toInt " + toInt);
    System.out.println("FloorDiv " + floorDiv);
    System.out.println("FloorMod " + floorMod);
    System.out.println("NextDown " + nextDown);
  }

  private static void objectsNullCheck() {
    List<String> mobileList = new ArrayList<>();
    mobileList.add("Iphone");
    mobileList.add("Samsung");
    mobileList.add("Sony");
    mobileList.add("Oppo");
    mobileList.add("Xiaomi");
    mobileList.add("LG");
    mobileList.add(null);
    System.out.println("Before List : " + mobileList);
    long nullCount = mobileList.stream().filter(Objects::isNull).count();
    long nonNullCount = mobileList.stream().filter(Objects::nonNull).count();
    System.out.println("Total null value in list " + nullCount);
    System.out.println("Total nonNull value in list " + nonNullCount);
  }

  private static void booleanMethods() {
    Boolean checkAnd = Boolean.logicalAnd(10 > 5, "Eazy".equals("Eazy"));
    Boolean checkOr = Boolean.logicalOr(10 > 5, "Eazy".equals("Eazy Bytes"));
    Boolean checkXor = Boolean.logicalXor(checkAnd, checkOr);
    System.out.println("CheckAnd " + checkAnd);
    System.out.println("CheckOr " + checkOr);
    System.out.println("CheckXor " + checkXor);
  }
}
