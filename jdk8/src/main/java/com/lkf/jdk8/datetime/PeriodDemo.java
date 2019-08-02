package com.lkf.jdk8.datetime;

import java.time.LocalDateTime;
import java.time.Period;

public class PeriodDemo {
    public static void periodMethod() {
        withYearsMethodExample();

        withMonthsMethodExample();

        withDaysMethodExample();

        toTotalMonthsMethodExample();

        subtractFromMethodExample();

        plusYearsMethodExample();

        plusMonthsMethodExample();

        plusDaysMethodExample();

        plusMethodExample();

        parseMethodExample();

        ofYearsMethodExample();

        ofWeeksMethodExample();

        ofMonthsMethodExample();

        ofDaysMethodExample();

        ofMethodExample();

        minusYearsMethodExample();

        minusMonthsMethodExample();

        minusDaysMethodExample();
    }

    public static void withYearsMethodExample() {
        Period period = Period.ofYears(2);
        System.out.println("Period.ofYears(2)：" + period.toString());
        period = period.withYears(5);
        System.out.println("period.withYears(5)：" + period.toString());
    }

    public static void withMonthsMethodExample() {
        Period period = Period.ofMonths(2);
        System.out.println("Period.ofMonths(2)：" + period.toString());
        period = period.withMonths(5);
        System.out.println("period.withMonths(5)：" + period.toString());
    }

    public static void withDaysMethodExample() {
        Period period = Period.ofDays(2);
        System.out.println("Period.ofDays(2)：" + period.toString());
        period = period.withDays(5);
        System.out.println("period.withDays(5)：" + period.toString());
    }

    public static void toTotalMonthsMethodExample() {
        Period period = Period.ofYears(2);
        System.out.println("Period.ofYears(2)：" + period.toTotalMonths());
    }

    public static void subtractFromMethodExample() {
        Period period = Period.ofYears(2);

        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);

        date = (LocalDateTime) period.subtractFrom(date);
        System.out.println(date);
    }

    public static void plusYearsMethodExample() {
        Period period = Period.ofYears(2);
        Period period1 = period.plusYears(1);
        System.out.println("Period.ofYears(2).plusYears(1)：" + period1.getYears());
    }

    public static void plusMonthsMethodExample() {
        Period period = Period.ofMonths(2);
        Period period1 = period.plusMonths(1);
        System.out.println("Period.ofMonths(2).plusMonths(1)：" + period1.getMonths());
    }

    public static void plusDaysMethodExample() {
        Period period = Period.ofDays(2);
        Period period1 = period.plusDays(1);
        System.out.println("Period.ofDays(2).plusDays(1)：" + period1.getDays());
    }

    public static void plusMethodExample() {
        Period period = Period.of(1, 5, 2);
        System.out.println(
                "Years: " + period.getYears() + ", Months: " + period.getMonths() + ", Days: " + period.getDays());
        Period period1 = period.plus(Period.ofDays(5));
        System.out.println(
                "Years: " + period1.getYears() + ", Months: " + period1.getMonths() + ", Days: " + period1.getDays());
    }

    public static void parseMethodExample() {
        Period period = Period.parse("P1Y2M3D");
        System.out.println(
                "Years: " + period.getYears() + ", Months: " + period.getMonths() + ", Days: " + period.getDays());
    }

    public static void ofYearsMethodExample() {
        Period period = Period.ofYears(2);
        System.out.println(period.getYears());
    }

    public static void ofWeeksMethodExample() {
        Period period = Period.ofWeeks(2);
        System.out.println(period.getDays());
    }

    public static void ofMonthsMethodExample() {
        Period period = Period.ofMonths(2);
        System.out.println(period.getMonths());
    }

    public static void ofDaysMethodExample() {
        Period period = Period.ofDays(2);
        System.out.println(period.getDays());
    }

    public static void ofMethodExample() {
        Period period = Period.of(1, 5, 2);
        System.out.println(
                "Years: " + period.getYears() + ", Months: " + period.getMonths() + ", Days: " + period.getDays());
    }

    public static void minusYearsMethodExample() {
        Period period = Period.ofYears(5);
        System.out.println(period.getYears());
        Period period1 = period.minusYears(3);
        System.out.println(period1.getYears());
    }

    public static void minusMonthsMethodExample() {
        Period period = Period.ofMonths(5);
        System.out.println(period.getMonths());
        Period period1 = period.minusMonths(3);
        System.out.println(period1.getMonths());
    }

    public static void minusDaysMethodExample() {
        Period period = Period.ofDays(5);
        System.out.println(period.getDays());
        Period period1 = period.minusDays(3);
        System.out.println(period1.getDays());
    }
}
