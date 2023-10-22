package demo.java8newfeature.functionalInterface;

import java.util.function.Function;

/**
 *   Chức năng tương tự như Predicate ngoại trừ với một thay đổi thay vì boolean, nó có thể trả về bất kỳ kiểu dữ liệu nào
 *   dưới dạng kết quả. Nó đại diện cho một hàm chấp nhận một đối số và tạo ra một kết quả.
 *
 *   BiFunction tương tự như Function nhưng nó có thể chấp nhận 2 tham số đầu vào và trả về một đầu ra theo kiểu dữ liệu được đề cập.
 */
public class FunctionExample {
  public static void main(String[] args) {
//  Creating a Function
    Function<String, String> convertStr = input -> input.toUpperCase();

//  Calling Function method toUpperCase
    System.out.println("The uppercase value of given input is : " + convertStr.apply("Eazy Bytes"));

    Function<String, String> sameValue = Function.identity();

//  Calling function method identity
    System.out.println("The value of given input is : " + sameValue.apply("Eazy bytes"));

//  Creating function
    Function<Integer, Integer> multiplyOperation = a -> {
      System.out.println("Double Operation");
      return a * 2;
    };
//  Using andThen() thực hiện hành của method được gọi trước rồi đến method truyền vào
    multiplyOperation = multiplyOperation.andThen(a -> {
      System.out.println("Triple Operation");
      return 3 * a;
    });
    System.out.println(multiplyOperation.apply(5));

    Function<Integer, Integer> divOperation = a -> {
      System.out.println("Division by 2 Operation");
      return a / 2;
    };
//  Ngược lại với andThen()
    divOperation = divOperation.compose(a -> {
      System.out.println("Devision by 3 Operation");
      return a / 3;
    });
    System.out.println(divOperation.apply(30));
  }
}
