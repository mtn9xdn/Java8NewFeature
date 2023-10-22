package demo.java8newfeature.functionalInterface;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator <T> là con của BiFunction <T, U, R>.
 * Chúng tôi sẽ sử dụng điều này trong các tình huống mà kiểu dữ liệu 2 tham số đầu vào và 1 tham số trả về giống nhau.
 * Nói cách khác, chúng ta có thể nói rằng BinaryOperator nhận hai đối số cùng kiểu và trả về kết quả có cùng kiểu đối số của nó.
 * Ngoài các phương thức mà nó kế thừa từ BiFunction <T, U, R>, nó cũng có 2 phương thức static tiện ích bên trong nó. Cả hai đều
 * sẽ được sử dụng để xác định tối thiểu hoặc tối đa của 2 phần tử dựa trên logic so sánh mà chúng tôi truyền vào
 */
public class BinaryOperatorExample {
  public static void main(String[] args) {
//  Creating a BinaryOperator
    BinaryOperator<String> appendAndConvert = (word1, word2) -> (word1 + word2).toUpperCase();

//  Calling BinaryOperator method
    System.out.println("The updated value after appending and converting is : " + appendAndConvert.apply("Hello ", "Eazy Bytes Students"));

    BinaryOperator<Integer> maxOperation = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
    System.out.println("The largest number is : " + maxOperation.apply(5,10));

    BinaryOperator<Integer> minOperation = BinaryOperator.minBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
    System.out.println("The smallest number is : " + minOperation.apply(10,5));
  }
}
