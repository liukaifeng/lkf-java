package com.lkf.jdk8.stream;

import com.lkf.jdk8.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    //构造数据
    public static List<Apple> appleList = Arrays.asList(new Apple(60, "green"), new Apple(80, "yellow"), new Apple(200, "red"));

    public static void main(String[] args) {
        //filter——过滤
        appleList.stream().filter(a -> a.getColor().equals("green")).forEach(System.out::println);
        // map——映射（一对一）
        appleList.stream().map(a -> a.getWeight() + 5).forEach(System.out::println);
        //sorted——排序
        appleList.stream().sorted(Comparator.comparing(Apple::getWeight)).forEach(System.out::println);
        //flatMap
        appleList.stream().flatMap(a -> Stream.of("苹果颜色：".concat(a.getColor()))).forEach(System.out::println);
        //forEach
        appleList.stream().forEach(System.out::println);
        //collect
        appleList.stream().map(a -> a.getColor().equals("green")).collect(Collectors.toList());
        //anyMatch
        appleList.stream().anyMatch(a -> a.getColor().contains("g"));
        //noneMatch
        appleList.stream().noneMatch(a -> a.getColor().contains("g"));
        //allMatch
        appleList.stream().allMatch(a -> a.getColor().contains("g"));
        //count
        appleList.stream().count();
        //reduce
        reduceTest();

    }

    private static void reduceTest() {
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }
}
