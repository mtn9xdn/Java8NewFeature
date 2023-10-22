package demo.java8newfeature.functionalInterface;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Nếu chúng ta có các tình huống mà kiểu dữ liệu của tham số đầu vào và đầu ra đều giống nhau, thì thay vì sử dụng
 * Function<T, R>, chúng ta có thể sử dụng UnaryOperator <T>
 */
public class UnaryOperatorExample {
  /**
   * nó là con của Hàm <T, T>. Vì vậy, tất cả các phương thức apply(), compose() và andThen() cũng có sẵn bên trong giao diện UnaryOperator.
   * @param args
   */
  public static void main(String[] args) {
//    Creating a Function
    Function<String, String> convertStr = input -> input.toUpperCase();

//    Calling Function method
    System.out.println("The uppercase value of given input is : " + convertStr.apply("Eazy Bytes"));

//    Creating a Function
    UnaryOperator<String> converStrWithUnary = input -> input.toUpperCase();

//    Calling Function method
    System.out.println("the uppercase value of given input with Unary operator is : " + converStrWithUnary.apply("Eazy Bytes"));
    System.out.println(convertStr.apply("abc").equals(converStrWithUnary.apply("abc")));

    System.out.println();

    Function<Integer, Integer> multiplyOperator = a -> {
      System.out.println("Multiply by 2 operator");
      return a * 2;
    };

    UnaryOperator<Integer> multiplyOperatorWithUnary = a -> {
      System.out.println("Multiply by 2 operator with Unary");
      return a * 2;
    };
    System.out.println(multiplyOperator.apply(10) == multiplyOperatorWithUnary.apply(10));
    multiplyOperator = multiplyOperator.andThen(multiplyOperatorWithUnary);
    System.out.println();
    System.out.println(multiplyOperator.apply(10));
  }
}
