package demo.java8newfeature.functionalInterface;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * Supplier interface sẽ luôn trả về một giá trị mà không chấp nhận bất kỳ đầu vào nào.
 * Hãy nghĩ đến các tình huống như tạo báo cáo hoặc OTP mà chúng tôi không cung cấp bất kỳ đầu vào nào.
 *
 * không có BiSupplier functional interface dành cho Supplier vì nó sẽ không chấp nhận bất kỳ thông số đầu vào nào
 */
public class SupplierExample {
  public static void main(String[] args) {
//    Creating a Supplier
    Supplier<Integer> gerCurrentDayOfMonth = () -> LocalDate.now().getDayOfMonth();

//    Invoking get method inside the Supplier
    System.out.println("Today's day of the month is : " + gerCurrentDayOfMonth.get());

//    Creating a Supplier
    Supplier<String> getCurrentDay = () -> LocalDate.now().getDayOfWeek().name();

//    Invoking get method inside the Supplier
    System.out.println("Today's day is : " + getCurrentDay.get());
  }
}
