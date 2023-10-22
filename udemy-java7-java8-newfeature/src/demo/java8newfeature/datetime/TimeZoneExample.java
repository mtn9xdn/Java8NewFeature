package demo.java8newfeature.datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.HijrahDate;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeZoneExample {
  public static void main(String[] args) {
    printAllZones();
    System.out.println("----------------------------");
    ZoneId india = ZoneId.of("Asia/Kolkata");
    ZonedDateTime indiaDateTime = ZonedDateTime.now(india);
    System.out.println("Time in India now : " + indiaDateTime);

    ZonedDateTime parisZonedDateTime = indiaDateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
    System.out.println("Time in Paris now " + parisZonedDateTime);

    ZoneOffset zoneOffset = ZoneOffset.of("+05:30");
    OffsetDateTime offsetDateTime = OffsetDateTime.now();
    System.out.println("Time in Indida now using offset " + offsetDateTime);

    OffsetDateTime targetOffsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.of("+01:00"));
    System.out.println("Time in Paris now using offset : " + targetOffsetDateTime);

    ZonedDateTime dateTime1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
    OffsetDateTime dateTime2 = OffsetDateTime.now(ZoneOffset.of("-05:00"));
    System.out.println(dateTime1);
    System.out.println(dateTime2);
    System.out.println(dateTime2.toEpochSecond() - dateTime1.toEpochSecond());

    ZonedDateTime dateTimePlus = dateTime1.plusMonths(6);
    OffsetDateTime dateTimePlus2 = dateTime2.plusMonths(6);
    System.out.println(dateTimePlus);
    System.out.println(dateTimePlus2);
    System.out.println(dateTimePlus2.toEpochSecond() - dateTimePlus.toEpochSecond());

    LocalDateTime ldt = LocalDateTime.of(2000, 6, 16, 12, 30, 0);
    ZonedDateTime parisDateTime = ldt.atZone(ZoneId.of("Europe/Paris"));
    System.out.println("Depart : " + parisDateTime);

    ZoneOffset asiaKolkata = ZoneOffset.of("+05:30");
    LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
    OffsetDateTime dateTimeInKolkata = OffsetDateTime.of(dateTime, asiaKolkata);
    System.out.println("Given time in Kolkata : " + dateTimeInKolkata);

    HijrahDate todayIslamic = HijrahDate.now();
    System.out.println("Islamic date for today " + todayIslamic);
  }

  private static void printAllZones() {
    LocalDateTime localDateTime = LocalDateTime.now();
    Map<String, String> result = ZoneId.getAvailableZoneIds().stream()
            .map(ZoneId::of)
            .map(zoneId -> new AbstractMap.SimpleEntry<>(zoneId.toString(),
                    localDateTime.atZone(zoneId).getOffset().getId().replaceAll("Z", "+00:00")))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, (oldValue, newValue) -> oldValue,
                    LinkedHashMap::new));
    result.forEach((k, v) -> System.out.println(String.format("%s (%s) %n", k, v)));
    System.out.println("/nTotal Zone IDs supported " + result.size());
  }
}
