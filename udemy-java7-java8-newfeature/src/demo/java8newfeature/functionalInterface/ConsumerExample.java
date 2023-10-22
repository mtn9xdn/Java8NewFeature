package demo.java8newfeature.functionalInterface;

import java.util.function.Consumer;

/**
 * Consumer interface sẽ luôn sử dụng / chấp nhận đầu vào đã cho để xử lý nhưng không trả
 * về bất kỳ thứ gì cho phương thức gọi.
 * <p>
 * BiConsumer tương tự như Consumer nhưng nó có thể chấp nhận 2 tham số đầu vào và không có giá trị trả về giống như Consumer
 */
public class ConsumerExample {
  public static void main(String[] args) {
//    Creating a Consumer
    Consumer<String> convertAndDisplay = input -> System.out.println("Converted value is : " + input.toUpperCase());

//    Invoking accept method inside the Consumer.
    convertAndDisplay.accept("Eazy Bytes");
    System.out.println("-----------------------");

//    Creating a Consumer
    Consumer<String> appendInput = input -> System.out.println("New value after appending is : " + " Hello " + input);

//    Invoking accept mdthod inside the Consumer
    appendInput.andThen(convertAndDisplay).accept(" Java 8");
  }
}
