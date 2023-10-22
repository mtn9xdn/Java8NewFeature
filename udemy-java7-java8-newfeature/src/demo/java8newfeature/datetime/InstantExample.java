package demo.java8newfeature.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

public class InstantExample {
  public static void main(String[] args) {
    Instant instant = Instant.ofEpochSecond(6);
    System.out.println(instant);
    System.out.println(Instant.ofEpochSecond(4, 1_000));
    System.out.println(Instant.ofEpochSecond(4, -1_000));
    Instant instantNow = Instant.now();
    System.out.println(instantNow);
    System.out.println("--------------------");
    Duration instantDuration = Duration.between(instant, instantNow);
    System.out.println(instantDuration);
    System.out.println("--------------------");
    LocalTime time = LocalTime.of(12, 30, 10);
    LocalTime time1 = LocalTime.of(16, 30, 10);
    Duration timeDuration = Duration.between(time, time1);
    System.out.println(timeDuration);
    System.out.println("--------------------");
    LocalDateTime dateTime = LocalDateTime.of(1989, Month.JUNE, 16, 12, 30, 10);
    LocalDateTime dateTime1 = LocalDateTime.of(2000, Month.JUNE, 16, 12, 30, 10);
    Duration dateTimeDuration = Duration.between(dateTime, dateTime1);
    System.out.println(dateTimeDuration);
    System.out.println("--------------------");
    LocalDate date = LocalDate.of(1989, 6, 16);
    LocalDate date1 = LocalDate.of(1989, 6, 26);
    Period locaDatePeriod = Period.between(date, date1);
    System.out.println(locaDatePeriod);
  }
}
