package demo.java8newfeature.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExample {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2022, 5, 31);
    LocalTime time = LocalTime.of(13, 47, 10);
    LocalDateTime dateTime = LocalDateTime.of(2022, 5, 31, 13, 47, 10);
    System.out.println("The Given Date and Time is : " + dateTime);
    LocalDateTime dateTimeVal = LocalDateTime.of(date, time);
    System.out.println("Get Year : " + dateTimeVal.getYear());
    System.out.println("Get Month : " + dateTimeVal.getMonth());
    System.out.println("Get Day of Month : " + dateTimeVal.getDayOfMonth());
    System.out.println("Get Day of Week : " + dateTimeVal.getDayOfWeek());
    System.out.println("Get Date of Year : " + dateTimeVal.getDayOfYear());
    System.out.println("Get Hour : " + dateTimeVal.getHour());
    System.out.println("Get Minutes : " + dateTimeVal.getMinute());
    System.out.println("Get Second : " + dateTimeVal.getSecond());
    System.out.println("Get Nano : " + dateTimeVal.getNano());
    System.out.println("---------------------");
    System.out.println("Is After datetime : " + dateTimeVal.isAfter(dateTime));
    System.out.println("Is Before datetime : " + dateTimeVal.isBefore(dateTime));
    System.out.println("Is Equal datetime : " + dateTimeVal.isEqual(dateTime));
    System.out.println("---------------------");
    System.out.println("Plus year : " + dateTimeVal.plusYears(1));
    System.out.println("Plus Week : " + dateTimeVal.plusWeeks(3));
    System.out.println("Plus Day : " + dateTimeVal.plusDays(2));
    System.out.println("Plus Hour : " + dateTimeVal.plusHours(4));
    System.out.println("Plus Minutes : " + dateTimeVal.plusMinutes(40));
    System.out.println("Plus Second : " + dateTimeVal.plusSeconds(20));
    System.out.println("---------------------");
    System.out.println("Minus Year : " + dateTimeVal.minusYears(1));
    System.out.println("Minus Week : " + dateTimeVal.minusWeeks(3));
    System.out.println("Minus Day : " + dateTimeVal.minusDays(2));
    System.out.println("Minus Hour : " + dateTimeVal.minusHours(4));
    System.out.println("Minus Minutes : " + dateTimeVal.minusMinutes(40));
    System.out.println("Minus Second : " + dateTimeVal.minusSeconds(20));
    System.out.println("---------------------");
    LocalDate dateLocal = dateTimeVal.toLocalDate();
    System.out.println("The Given Time Value Is : " + dateLocal);
    LocalTime timeLocal = dateTimeVal.toLocalTime();
    System.out.println("The Given Date Value Is : " + timeLocal);
  }
}
