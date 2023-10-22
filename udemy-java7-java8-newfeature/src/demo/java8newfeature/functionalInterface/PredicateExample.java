package demo.java8newfeature.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate Functional Interface xử lý các tình huống, trong đó chúng tôi chấp nhận một tham số đầu vào và
 * trả về boolean sau khi xử lý đầu vào.
 *
 * BiPredicate tương tự như Predicate nhưng nó có thể chấp nhận 2 tham số đầu vào và trả về giá trị boolean
 */
public class PredicateExample {
  public static void main(String[] args) {
//    Creating predicate
    Predicate<Integer> isEven = i -> i % 2 == 0;
    Predicate<Integer> isGreaterThan50 = i -> i > 50;

//    Call predicate
    System.out.println("Is the number 61 is even : " + isEven.test(61));

//    Call predicate and
    System.out.println("Is the number 61 is even and greater 50 : " + isGreaterThan50.and(isEven).test(61));

//    Call predicate or
    System.out.println("Is the number 61 is even or greater 50 : " + isGreaterThan50.or(isEven).test(61));

//    Negate trả về phủ định của predicate
    System.out.println("Is the number 61 is odd : " + isEven.negate().test(61));

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> collect = list.stream()
            .filter(isEven)
            .collect(Collectors.toList());

    System.out.println("List of even numbers from the list : " + collect);

    Predicate<String> checkEquality = Predicate.isEqual("Eazy Bytes");
    System.out.println("Is the input string is equal : " + checkEquality.test("Eazy Bytes"));

  }
}
