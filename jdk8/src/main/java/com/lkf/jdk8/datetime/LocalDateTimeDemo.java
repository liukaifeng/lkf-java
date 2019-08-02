package com.lkf.jdk8.datetime;

import java.time.*;

/**
 * Java 8 LocalDateTime API
 */
public class LocalDateTimeDemo {
    /**
     * 创建 LocalDateTime 对象
     */
    public static void createLocalDateTime() {
        // 获取当前的日期时间对象
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        // 从指定时区获取当前的日期时间对象
        LocalDateTime dateTime2 = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(dateTime2);

        // 从指定时钟获取当前的日期时间对象
        LocalDateTime dateTime3 = LocalDateTime.now(Clock.systemUTC());
        System.out.println(dateTime3);

        // 获取指定的日期时间对象
        LocalDateTime dateTime4 = LocalDateTime.of(2017, Month.JULY, 12, 10, 35, 55);
        System.out.println(dateTime4);
    }

    /**
     * 从LocalDateTime获取年，月，日
     */
    public static void getYearMonthDayFromLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Year : " + dateTime.getYear());
        System.out.println("Month : " + dateTime.getMonth().getValue());
        System.out.println("Day of Month : " + dateTime.getDayOfMonth());
        System.out.println("Day of Week : " + dateTime.getDayOfWeek());
        System.out.println("Day of Year : " + dateTime.getDayOfYear());
    }

    /**
     * 从LocalDateTime获取Hour，Minute，Second
     */
    public static void getHourMinuteSecondfromLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Hour（小时） : " + dateTime.getHour());
        System.out.println("Minute （分钟）: " + dateTime.getMinute());
        System.out.println("Second （秒）: " + dateTime.getSecond());
        System.out.println("Nano : （纳秒）" + dateTime.getNano());
    }

    /**
     * 用LocalDateTime添加或减去年，月，日，小时，分钟和秒
     */
    public static void addOrSubstractUsingLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        // LocalDateTime 加法运算
        System.out.println("加指定天数 : " + dateTime.plusDays(5));
        System.out.println("加指定月数 : " + dateTime.plusMonths(15));
        System.out.println("加指定年数 : " + dateTime.plusYears(5));
        System.out.println("加上指定小时数: " + dateTime.plusHours(2));
        System.out.println("加上指定分钟数 : " + dateTime.plusMinutes(30));
        System.out.println("加上指定秒杀 : " + dateTime.plusSeconds(20));

        // LocalDateTime 减法运算
        System.out.println("减去指定天数 : " + dateTime.minusDays(5));
        System.out.println("减去指定月数 : " + dateTime.minusMonths(15));
        System.out.println("减去指定年数 : " + dateTime.minusYears(5));
        System.out.println("减去指定小时数 : " + dateTime.minusHours(2));
        System.out.println("减去指定分钟数 : " + dateTime.minusMinutes(30));
        System.out.println("减去指定秒数 : " + dateTime.minusSeconds(20));
    }

    /**
     * 比较Java中的LocalDateTime对象
     */
    public static void compareLocalDateTimeObjects() {
        LocalDateTime dateTime1 = LocalDateTime.of(2019, 07, 22, 10, 55, 25);
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 04, 11, 05, 35, 26);
        LocalDateTime dateTime3 = LocalDateTime.of(2017, 12, 22, 10, 55, 25);

        // isBefore()
        if (dateTime1.isBefore(dateTime2)) {
            System.out.println("dateTime1 小于 dateTime2");
        }

        // isAfter()
        if (dateTime2.isAfter(dateTime3)) {
            System.out.println("dateTime2 大于 dateTime3");
        }

        // isEqual()
        if (dateTime1.isEqual(dateTime3)) {
            System.out.println("dateTime1 等于 dateTime3");
        }

        // compareTo()
        if (dateTime1.compareTo(dateTime3) == 0) {
            System.out.println("dateTime1 等于 dateTime3");
        }
    }

    /**
     * 从LocalDateTime转换为LocalDate
     */
    public static void convertLocalDateTimeToLocalDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("当前时间：" + dateTime);

        LocalDate localDate = dateTime.toLocalDate();
        System.out.println("获取日期部分：" + localDate);
    }

    /**
     * 从LocalDateTime转换为LocalTime
     */
    public static void convertLocalDateTimeToLocalTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("当前日期时间：" + dateTime);

        LocalTime localDate = dateTime.toLocalTime();
        System.out.println("当前时间部分：" + localDate);
    }

}
