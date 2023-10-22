package demo.java8newfeature.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterExample {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2022, 6, 1);
    String baseISO = date.format(DateTimeFormatter.BASIC_ISO_DATE);
    System.out.println(baseISO);

    String localISO = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.println(localISO);

    LocalDate baseISODate = LocalDate.parse("20220601", DateTimeFormatter.BASIC_ISO_DATE);
    System.out.println(baseISODate);

    LocalDate localISODate = LocalDate.parse("2022-06-01", DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.println(localISODate);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.of(2022, 6, 1);
    String fomarttedDate = localDate.format(formatter);
    System.out.println(fomarttedDate);

    DateTimeFormatter germanFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.GERMAN);
    LocalDate date1 = LocalDate.of(2022, 1, 6);
    String formattedDateGer = date1.format(germanFormatter);
    System.out.println(formattedDateGer);
  }
}
