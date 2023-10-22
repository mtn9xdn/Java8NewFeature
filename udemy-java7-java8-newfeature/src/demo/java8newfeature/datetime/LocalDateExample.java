package demo.java8newfeature.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateExample {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2022, 5, 25);
    System.out.println("Given Date is : " + date);

    int year = date.getYear();
    System.out.println("Given Year is : " + year);

    Month month = date.getMonth();
    int monthIsNumbers = date.getMonthValue();
    System.out.println("Given Month is : " + month + " Or " + monthIsNumbers);

    int day = date.getDayOfMonth();
    System.out.println("Given Day is : " + day);

    DayOfWeek dow = date.getDayOfWeek();
    System.out.println("Given Day Of The Week is : " + dow);

    int len = date.lengthOfMonth();
    System.out.println("Given Length Of Month is : " + len);

    boolean leap = date.isLeapYear();
    System.out.println("Is A Leap Year : " + leap);

    System.out.println("---------------------");

    int year1 = date.get(ChronoField.YEAR);
    System.out.println("Given Year is : " + year1);

    int month1 = date.get(ChronoField.MONTH_OF_YEAR);
    System.out.println("Given Month is : " + month1);

    int day1 = date.get(ChronoField.DAY_OF_MONTH);
    System.out.println("Given Day is : " + day1);

    LocalDate parseDate = LocalDate.parse("2000-06-16");
    System.out.println("Parse Date is : " + parseDate);
    LocalDate today = LocalDate.now();
  }
}
