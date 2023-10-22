package demo.java7newfeature;

import demo.java7newfeature.sp.CustomResource;
import demo.java7newfeature.sp.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TryWithResources {
  public static void main(String[] args) throws Exception {
    System.out.println("---------Before Java7---------");
    beforeJava7();
    System.out.println();
    System.out.println("---------In Java7---------");
    Java7();
    System.out.println("-------------------");
    withCustomesInJava7();
    System.out.println("-------------------");
    stream();
    System.out.println("-------------------");
    Employee john = new Employee("John P.", 1500, "M");
    Employee sarah = new Employee("Sarah M.", 2000, "F");
    Employee charles = new Employee("Charles B.", 1700, "M");
    Employee mary = new Employee("Mary T.", 5000, "F");
    Employee sophia = new Employee("Sophia B.", 7000, "F");
    List<Employee> employees = Arrays.asList(john, sarah, charles, mary, sophia);

    Predicate<Employee> predicate = e -> e.isFemale() && e.getSalary() > 2500;

    employees.stream()
            .filter(predicate)
            .forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));

  }

  /**
   * Before java 7 thì khối try ko có () và cần phải close.
   *
   * @throws IOException
   */
  public static void beforeJava7() throws IOException {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("C:\\Users\\NamMT\\Desktop\\def.txt"));
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        System.out.println(currentLine);
      }
    } finally {
      br.close();
    }
  }

  /**
   * In java 7 thì khối try có () và ko cần phải close.
   *
   * @throws IOException
   */
  public static void Java7() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\NamMT\\Desktop\\def.txt"));) {
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        System.out.println(currentLine);
      }
    } catch (FileNotFoundException e) {
      e.getMessage();
    }
  }

  /**
   * Test khi BufferedReader đã implement Closeable và có phương thức close()
   *
   * @throws Exception
   */
  public static void withCustomesInJava7() throws Exception {
    try (CustomResource cr = new CustomResource();) {
      cr.readFromResource();
    }
  }

  public static void stream() {
    List<String> mylist = Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1");
    mylist.stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
  }
}
