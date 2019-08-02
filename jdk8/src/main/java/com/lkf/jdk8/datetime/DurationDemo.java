package com.lkf.jdk8.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo {
    public static void durationMethod() {
        Duration d1 = Duration.between(LocalTime.MAX, LocalTime.NOON);
        Duration d2 = Duration.between(LocalTime.NOON, LocalTime.MAX);
        System.out.println("d1 是否是负数：" + d1.isNegative());
        System.out.println("d2 是否是负数：" + d2.isNegative());
        System.out.println("d1 与 d2 相差秒数：" + d1.get(ChronoUnit.SECONDS));
        System.out.println("d1 加上 d2 ：" + d1.plus(d2).getSeconds());
        System.out.println("d1 减去 d2 ：" + d1.minus(d2).getSeconds());
    }
}
