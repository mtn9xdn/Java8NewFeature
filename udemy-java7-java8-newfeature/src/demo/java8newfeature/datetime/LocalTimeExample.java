package demo.java8newfeature.datetime;

import java.time.LocalTime;

public class LocalTimeExample {
  public static void main(String[] args) {
    LocalTime time = LocalTime.of(12, 30, 10);
    System.out.println("Given time is : " + time);

    int hour = time.getHour();
    System.out.println("Given hour is : " + hour);

    int minutes = time.getMinute();
    System.out.println("Given minites is : " + minutes);

    int second = time.getSecond();
    System.out.println("Given second is : " + second);

    LocalTime parseTime = LocalTime.parse("12:30:10");
    System.out.println("Given parse time is : " + parseTime);
    LocalTime currentTime = LocalTime.now();
    System.out.println("Given current time is : " + currentTime);
  }
}
