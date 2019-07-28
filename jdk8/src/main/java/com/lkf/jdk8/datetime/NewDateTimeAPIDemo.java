package com.lkf.jdk8.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * Java 8 新date和timeAPI
 */
public class NewDateTimeAPIDemo {
    public static void main(String[] args) {
//        localDateDemo();
//        LocalTimeDemo.createLocalTime();
//        LocalTimeDemo.getHourMinuteSecondfromLocalTime();
//        LocalTimeDemo.addorSubtractHoursMinutesAndSecondstoLocalTime();
//        LocalTimeDemo.compareLocalTimeObjects();
//        LocalTimeDemo.convertStringToLocalTime();
        LocalTimeDemo.convertLocalTimeToString();
    }

    public static void localDateDemo() {
        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println("当前日期=" + today);

        //通过输入参数创建 LocalDate 对象
        LocalDate firstDay_201907 = LocalDate.of(2019, Month.JULY, 1);
        System.out.println("通过输入参数创建 LocalDate 对象=" + firstDay_201907);

        //上海日期
        LocalDate shanghaiDate = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("上海日期=" + shanghaiDate);
    }


}
