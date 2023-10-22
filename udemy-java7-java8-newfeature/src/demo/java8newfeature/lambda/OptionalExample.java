package demo.java8newfeature.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {
  public static void main(String[] args) {
//    beforeJava8();
    withJava8();
  }

  public static void beforeJava8() {
    List<String> students1 = new ArrayList<>();
    students1.add("Khanh");

    List<String> students2 = new ArrayList<>();
    students2.add("Thanh");
    students2.add("Dung");

    List<List<String>> students = Arrays.asList(students1, students2);

    Stream<List<String>> stream = students.stream();
    System.out.println("Filterring stream: ");
    stream.flatMap(l -> l.stream())
            .filter(s -> "Khanh".equals(s.toString()))
            .forEach(o -> System.out.println("Student name " + o.toString()));
  }

  public static void withJava8() {
    String[] str = new String[10];
    str[5] = "Eazy Bytes";

    Optional<String> empty = Optional.empty();
    System.out.println(empty);

//    Khi chắc rằng có tồn tại giá trị thì dùng of ngược lại thì dùng ofNullable()
    Optional<String> value = Optional.of(str[5]);
    System.out.println(value);

    Optional<String> nullValue = Optional.ofNullable(str[4]);
    nullValue.ifPresent(System.out::println);
    System.out.println(nullValue.orElse("No Value"));

    Optional<String> nonEmptyString = Optional.of("Eazy Bytes");
    Optional<String> emptyString = Optional.empty();

    System.out.println("Non-Empty Optional: " + nonEmptyString.map(String::toUpperCase));
    System.out.println("Empty Optional: " + emptyString.map(String::toUpperCase));

    Optional<Optional<String>> nonEmptyOptionalInput = Optional.of(Optional.of("Eazy Bytes"));
    System.out.println("Optional value: " + nonEmptyOptionalInput);
    System.out.println("Optional map: " + nonEmptyOptionalInput.map(input -> input.map(String::toUpperCase)));
    System.out.println("Optional flatmap: " + nonEmptyOptionalInput.flatMap(input -> input.map(String::toUpperCase)));

    Optional<String> country = Optional.of("INDIA");
    Optional<String> emptyCountry = Optional.empty();

    // Filter on Optional
    System.out.println(country.filter(g -> g.equals("indida"))); // Optional empty
    System.out.println(country.filter(g -> g.equals("INDIA"))); // Optional [INDIDA]
    System.out.println(emptyCountry.filter(g -> g.equalsIgnoreCase("INDIDA"))); // Optional empty

    if (country.isPresent()) {
      System.out.println("Value available");
    }

    country.ifPresent(c -> System.out.println("In country option, value available is: " + c));

    // Condition failed, no output will be printed.
    emptyCountry.ifPresent(c -> System.out.println("In country option, value available is " + c));

    // orElse thực hiện vẫn in value nếu tồn tại. Ngược lại thì in trong ()
    System.out.println(country.orElse("No country data available"));
    System.out.println(emptyCountry.orElse("No country data available"));
    System.out.println(emptyCountry.orElseGet(() -> "No country data available"));
    System.out.println(emptyCountry.orElseThrow(NoSuchElementException::new));
  }
}
