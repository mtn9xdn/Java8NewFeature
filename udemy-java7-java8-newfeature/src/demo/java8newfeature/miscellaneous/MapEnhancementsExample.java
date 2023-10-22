package demo.java8newfeature.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class MapEnhancementsExample {
  /**
   * nhóm java 8 cung cấp một số phương thức mặc định bên trong giao diện Map. Dưới đây là một số cải tiến quan trọng từng xảy ra đối với Map.
   * forEach () -> Sử dụng điều này, chúng ta có thể lặp lại các giá trị Map một cách dễ dàng
   * Entry.comparingByValue -> Sắp xếp các phần tử Map dựa trên giá trị.
   * Entry.comparingByKey -> Sắp xếp các phần tử Map dựa trên khóa.
   * getOrDefault () -> có thể được sử dụng để chuyển một giá trị mặc định thay vì null nếu không có khóa.
   * computelfAbsent () -> Có thể được sử dụng để tính toán một giá trị nếu không có cho khóa đã cho.
   * computelfPresent () -> Nếu có khóa được chỉ định, hãy tính giá trị mới cho nó.
   * Compute () -> Tính giá trị mới cho một khóa nhất định và lưu trữ nó trong Map.
   * remove (key, value) -> để xóa một phần tử Map nếu cả key & value đều khớp.
   * Replace () -> để thay thế các giá trị nếu khóa có sẵn.
   * ReplaceAll () -> để thay thế tất cả các giá trị bên trong Map.
   *
   * @param args
   */
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("India", "Delhi");
    map.put("USA", "Washington");
    map.put("China", "Beijing");
    map.put("Germany", "Berlin");
    map.put("Endland", "London");
    map.put("Australia", "Canberra");
    map.forEach((country, capital) -> System.out.println("The capital of " + country + " is : " + capital));
    System.out.println("-----------------------");
    map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(System.out::println);
    System.out.println("-----------------------");
    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(System.out::println);
    System.out.println("-----------------------");
    System.out.println(map.getOrDefault("Russia", "No Data Present"));
    System.out.println("-----------------------");
    map.computeIfAbsent("Spain", name -> "Madrid");
    map.computeIfPresent("USA", (k, v) -> "Washington DC");
    map.compute("India", (key, val) -> "New " + val);
    map.remove("England", "London");
    map.replaceAll((country, capital) -> capital.toUpperCase());
    map.replace("India", "Delhi");
    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(System.out::println);
  }
}
