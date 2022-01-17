package com.beniregev.g_datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Java8DateTimeApiDemo {
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;
    private ZonedDateTime zonedDateTime;

    /**
     * Demonstrating and manipulation of {@link LocalDate} class of Java Time API
     */
    public void getCurrentDate() {
        localDate = LocalDate.now();
        System.out.println("getCurrentDate(): ");
        System.out.println("\tLocalDate.now() = " + localDate);
        System.out.println("\tIs Leap Year? " + localDate.isLeapYear());
        System.out.println("\tDay of Week Name = " + localDate.getDayOfWeek().name());
        System.out.println("\tThe Date 23 days ago was = " + localDate.minusDays(23));
        System.out.println(String.format("\tlocalDate is now = %s", localDate.format(DateTimeFormatter.ISO_LOCAL_DATE)));
        System.out.println("\tThe Date 6 months from now will be = " + localDate.plusMonths(6));
        System.out.println(String.format("\tlocalDate is now = %s", localDate.format(DateTimeFormatter.BASIC_ISO_DATE)));
        System.out.println(String.format("\tlocalDate is now = %s", localDate.format(DateTimeFormatter.ISO_ORDINAL_DATE)));
        System.out.println(String.format("\tlocalDate is now = %s", localDate.format(DateTimeFormatter.ISO_WEEK_DATE)));
    }

    /**
     * Demonstrating and manipulation of {@link LocalTime} class of Java Time API
     */
    public void getCurrentTime() {
        localTime = LocalTime.now();
        System.out.println("getCurrentTime(): ");
        System.out.println("\tLocalTime.now() = " + localTime);
    }

    /**
     * Demonstrating and manipulation of {@link LocalDateTime} class of Java Time API
     */
    public void getCurrentDateTime() {
        localDateTime = LocalDateTime.now();
        System.out.println("getCurrentDateTime(): ");
        System.out.println("\tLocalDateTime.now() = " + localDateTime);
    }

    /**
     * Demonstrating and manipulation of {@link ZonedDateTime} class of Java Time API
     */
    public void getCurrentZonedDateTime() {
        zonedDateTime = ZonedDateTime.now();
        System.out.println("getCurrentZonedDateTime() = " + zonedDateTime);
        System.out.println("\tZonedDateTime(\"GMT\") = " + ZonedDateTime.now(ZoneId.of("GMT")));
        System.out.println("\tZonedDateTime(\"Asia/Jerusalem\") = " + ZonedDateTime.now(ZoneId.of("Asia/Jerusalem")));
        System.out.println("\tZonedDateTime(\"Africa/Johannesburg\") = " + ZonedDateTime.now(ZoneId.of("Africa/Johannesburg")));
        System.out.println("\tZonedDateTime(ZoneId.systemDefault()) = " + ZonedDateTime.now(ZoneId.systemDefault()));
        System.out.println("\tPrint Available ZoneId(s): ");
        ZoneId.getAvailableZoneIds().stream().sorted().forEach(z -> System.out.println("\t\t" + z));

    }

    /**
     * Run the demos
     * @param args
     */
    public static void main(String[] args) {
        Java8DateTimeApiDemo demo = new Java8DateTimeApiDemo();
        demo.getCurrentDate();
        demo.getCurrentTime();
        demo.getCurrentDateTime();
        demo.getCurrentZonedDateTime();
    }
}
