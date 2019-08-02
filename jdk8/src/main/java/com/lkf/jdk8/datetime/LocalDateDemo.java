package com.lkf.jdk8.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Java 8 LocalDate API
 */
public class LocalDateDemo {
    /**
     * 创建当前日期和特定日期
     */
    public static void createLocalDate() {
        // 在默认时区中从系统时钟获取当前日期。
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate.now()：" + localDate);
        // 从指定的时钟获取当前日期。
        LocalDate localDate1 = LocalDate.now(Clock.systemDefaultZone());
        System.out.println("LocalDate.now(Clock.systemDefaultZone())：" + localDate1);
        // 从指定时区的系统时钟获取当前日期。
        LocalDate localDate3 = LocalDate.now(Clock.system(ZoneId.of("Indian/Cocos")));
        System.out.println("LocalDate.now(Clock.system(ZoneId.of(\"Indian/Cocos\")))：" + localDate3);
        // 从年，月和日获得LocalDate的实例。
        LocalDate localDate2 = LocalDate.of(1991, Month.MARCH, 24);
        System.out.println("LocalDate.of(1991, Month.MARCH, 24)：" + localDate2);
        // 从年，月和日获得LocalDate的实例。
        LocalDate localDate5 = LocalDate.of(1991, 12, 24);
        System.out.println("LocalDate.of(1991, 12, 24)：" + localDate5);
    }

    /**
     * 从LocalDate获取年，月，日
     */
    public static void getYearMonthDay() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Year : " + localDate.getYear());
        System.out.println("Month : " + localDate.getMonth().getValue());
        System.out.println("Day of Month : " + localDate.getDayOfMonth());
        System.out.println("Day of Week : " + localDate.getDayOfWeek());
        System.out.println("Day of Year : " + localDate.getDayOfYear());
    }

    /**
     * 向LocalDate添加或减去天，月，周和年
     */
    public static void addOrSubstractUsingLocalDate() {
        LocalDate localDate = LocalDate.now();
        // LocalDate 添加指定年月日的方法
        System.out.println("添加 days : " + localDate.plusDays(5));
        System.out.println("添加 months : " + localDate.plusMonths(15));
        System.out.println("添加 weeks : " + localDate.plusWeeks(45));
        System.out.println("添加 years : " + localDate.plusYears(5));

        // LocalDate 减去指定年月日的方法
        System.out.println("减去 days : " + localDate.minusDays(5));
        System.out.println("减去 months : " + localDate.minusMonths(15));
        System.out.println("减去 weeks : " + localDate.minusWeeks(45));
        System.out.println("减去 years : " + localDate.minusYears(5));
    }

    /**
     * 比较LocalDate对象
     */
    public static void compareLocalDate() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2017, Month.MAY, 14);
        LocalDate localDate3 = LocalDate.of(2016, Month.MAY, 15);

        // isEqual()
        if (localDate1.isEqual(localDate2)) {
            System.out.println("localDate1 等于 localDate2");
        } else {
            System.out.println("localDate1 不等于 localDate2");
        }

        // ifAfter()
        if (localDate2.isAfter(localDate3)) {
            System.out.println("localDate2 大于 localDate3");
        }

        // isBefore()
        if (localDate3.isBefore(localDate1)) {
            System.out.println("localDate3 小于 localDate1");
        }
    }

    /**
     * 从LocalDate获取月或年的天数
     */
    public static void getDaysFromMonthAndYear() {
        LocalDate localDate1 = LocalDate.of(2017, Month.JANUARY, 1);
        LocalDate localDate2 = LocalDate.of(2016, Month.FEBRUARY, 1);

        // Number of days in a month
        System.out.println(localDate1.getMonth() + " 月天数 : " + localDate1.lengthOfMonth());
        System.out.println(localDate2.getMonth() + " 月天数 : " + localDate2.lengthOfMonth());

        // Number of days in a year
        System.out.println(localDate1.getYear() + " 年天数 : " + localDate1.lengthOfYear());
        System.out.println(localDate2.getYear() + " 年天数 : " + localDate2.lengthOfYear());
    }

    /**
     * 检查给定年份是否为闰年
     */
    public static void checkIfYearIsLeapYear() {
        LocalDate localDate1 = LocalDate.of(2017, Month.JANUARY, 1);
        LocalDate localDate2 = LocalDate.of(2016, Month.JANUARY, 1);

        if (localDate1.isLeapYear()) {
            System.out.println(localDate1.getYear() + " 是闰年");
        } else {
            System.out.println(localDate1.getYear() + " 不是闰年");
        }

        if (localDate2.isLeapYear()) {
            System.out.println(localDate2.getYear() + " 是闰年");
        } else {
            System.out.println(localDate2.getYear() + " 不是闰年");
        }
    }

    /**
     * 将String转换为LocalDate的API
     */
    public static void convertStringToLocalDate() {
        // ISO Date
        LocalDate localDate = LocalDate.parse("2017-05-03", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate：" + localDate);

        // yyyy/MM/dd pattern
        LocalDate localDate1 = LocalDate.parse("2017/05/12", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("2017/05/12 格式化：" + localDate1);

        // dd-LL-yyyy pattern
        LocalDate localDate4 = LocalDate.parse("12-01-2017", DateTimeFormatter.ofPattern("dd-LL-yyyy"));
        System.out.println("12-01-2017 格式化：" + localDate4);
    }

    /**
     * LocalDate 转换为指定日期格式字符串
     */
    public static void convertLocalDatetoString() {
        // ISO Date
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(localDate.format(dateFormatter));

        // yyyy/MM/dd pattern
        DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(localDate.format(dateFormatter1));

        // MMMM dd, yyyy pattern
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(localDate.format(dateFormatter2));

        // dd-MMM-yyyy pattern
        DateTimeFormatter dateFormatter3 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        System.out.println(localDate.format(dateFormatter3));

        // dd-LL-yyyy pattern
        DateTimeFormatter dateFormatter4 = DateTimeFormatter.ofPattern("dd-LL-yyyy");
        System.out.println(localDate.format(dateFormatter4));
    }
}
