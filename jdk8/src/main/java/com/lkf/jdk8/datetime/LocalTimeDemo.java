package com.lkf.jdk8.datetime;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Java 8 LocalTime API
 */
public class LocalTimeDemo {
    /**
     * 创建 LocalTime 对象
     */
    public static void createLocalTime() {
        // 当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间：" + localTime);

        // 指定时间
        LocalTime localTime2 = LocalTime.of(4, 30, 45);
        System.out.println("指定时间：" + localTime2);

        //当前时钟默认时区
        LocalTime localTime3 = LocalTime.now(Clock.systemDefaultZone());
        System.out.println("当前时钟默认时区：" + localTime3);
        //指定时区
        LocalTime localTime4 = LocalTime.now(Clock.system(ZoneId.of("Asia/Shanghai")));
        System.out.println("指定时区：" + localTime4);
    }

    /**
     * LocalTime 获取时分秒方法
     */
    public static void getHourMinuteSecondfromLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println("获取 hour-of-day : " + localTime.getHour());
        System.out.println("获取 minute-of-hour : " + localTime.getMinute());
        System.out.println("获取 second-of-minute : " + localTime.getSecond());
        System.out.println("获取nano-of-second : " + localTime.getNano());
    }

    /**
     * LocalTime 向LocalTime添加或减去小时，分钟和秒
     */
    public static void addorSubtractHoursMinutesAndSecondstoLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间 : " + localTime);

        // LocalTime 加法运算
        System.out.println("加上指定小时 : " + localTime.plusHours(2));
        System.out.println("加上指定分钟 : " + localTime.plusMinutes(30));
        System.out.println("加上指定秒数 : " + localTime.plusSeconds(20));
        System.out.println("加上指定纳秒 : " + localTime.plusNanos(60000));

        // LocalTime 减法运算
        System.out.println("减去指定小时 : " + localTime.minusHours(2));
        System.out.println("减去指定分钟 : " + localTime.minusMinutes(30));
        System.out.println("减去指定秒数 : " + localTime.minusSeconds(20));
        System.out.println("减去指定纳秒 : " + localTime.minusNanos(60000));
    }

    /**
     * 比较Java中的LocalTime对象的方法
     */
    public static void compareLocalTimeObjects() {
        LocalTime localTime1 = LocalTime.of(9, 10, 50);
        LocalTime localTime2 = LocalTime.of(9, 10, 50);
        LocalTime localTime3 = LocalTime.of(11, 45, 20);

        // compareTo()
        if (localTime1.compareTo(localTime2) == 0) {
            System.out.println("localTime1 和 localTime2 相等");
        } else {
            System.out.println("localTime1 和 localTime2 不相等");
        }

        // isBefore()
        if (localTime2.isBefore(localTime3)) {
            System.out.println("localTime2 小于 localTime3");
        }

        // isAfter()
        if (localTime3.isAfter(localTime1)) {
            System.out.println("localTime3 大于 localTime1");
        }
    }

    /**
     * 将String转换为LocalTime的方法
     */
    public static void convertStringToLocalTime() {
        LocalTime isoTime = LocalTime.parse("10:15:30", DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("isoTime：" + isoTime);

        // hour-of-day (0-23)
        LocalTime localTime = LocalTime.parse("22:45:30", DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("hour-of-day (0-23)：" + localTime);

        // clock-hour-of-am-pm (1-24)
        LocalTime localTime2 = LocalTime.parse("22:45:30", DateTimeFormatter.ofPattern("kk:mm:ss"));
        System.out.println("clock-hour-of-am-pm (1-24)：" + localTime2);
    }

    /**
     * 将LocalTime转换为String的方法
     */
    public static void convertLocalTimeToString() {
        LocalTime localTime = LocalTime.now();

        // ISO Format
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println("ISO Format：" + localTime.format(timeFormatter));

        // hour-of-day (0-23)
        DateTimeFormatter timeFormatter1 = DateTimeFormatter
                .ofPattern("HH:mm:ss");
        System.out.println("hour-of-day (0-23)：" + localTime.format(timeFormatter1));

        // clock-hour-of-am-pm (1-24)
        DateTimeFormatter timeFormatter2 = DateTimeFormatter
                .ofPattern("kk:mm:ss");
        System.out.println("clock-hour-of-am-pm (1-24)：" + localTime.format(timeFormatter2));

        // clock-hour-of-am-pm (1-12)
        DateTimeFormatter timeFormatter3 = DateTimeFormatter
                .ofPattern("hh:mm:ss a");
        System.out.println("clock-hour-of-am-pm (1-12)：" + localTime.format(timeFormatter3));

        // hour-of-am-pm (0-11)
        DateTimeFormatter timeFormatter4 = DateTimeFormatter
                .ofPattern("KK:mm:ss a");
        System.out.println("hour-of-am-pm (0-11)：" + localTime.format(timeFormatter4));
    }
}
