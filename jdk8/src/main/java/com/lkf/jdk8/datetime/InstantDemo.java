package com.lkf.jdk8.datetime;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class InstantDemo {


    /**
     * 实例化 Instant
     */
    public static void instantMethod() {
        Instant instant = Instant.parse("2019-08-02T10:37:30.00Z");
        Instant minmus2Days=  instant.minus(Duration.ofDays(2));
        Instant pulus5Days=  instant.plus(Duration.ofDays(5));

        System.out.println("Instant 对象实例："+instant);
        System.out.println("Instant 减去2天："+minmus2Days);
        System.out.println("Instant 加上5天："+pulus5Days);
        System.out.println("Instant 是否支持单位DAYS："+instant.isSupported(ChronoUnit.DAYS));
        System.out.println("Instant 是否支持单位YEARS："+instant.isSupported(ChronoUnit.YEARS));
    }
}
