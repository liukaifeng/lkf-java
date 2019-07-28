package com.lkf.jdk8.collection;

import com.lkf.jdk8.Apple;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorDemo {
    //构造数据
    public static List<Apple> appleList = Arrays.asList(new Apple(60, "green", 12.5, "北京"), new Apple(80, "yellow", 10.1, "天津"), new Apple(200, "red", 6.9, "上海"));

    public static void main(String[] args) {
        //Collectors.counting()
        appleList.stream().collect(Collectors.counting());
        appleList.stream().count();

        //比较器
        Comparator<Apple> appleComparator = Comparator.comparingInt(Apple::getWeight);
        //最大值
        Optional<Apple> maxApple = appleList.stream().max(appleComparator);
        Optional<Apple> maxApple2 = appleList.stream().collect(Collectors.maxBy(appleComparator));
        //最小值
        Optional<Apple> minApple = appleList.stream().min(appleComparator);
        Optional<Apple> minApple2 = appleList.stream().collect(Collectors.minBy(appleComparator));

        //汇总（数量、求和、平均值、最小值、最大值）
        IntSummaryStatistics intSummaryStatistics = appleList.stream().collect(Collectors.summarizingInt(Apple::getWeight));
        System.out.println(intSummaryStatistics);
        //求和
        int sumValue = appleList.stream().mapToInt(Apple::getWeight).sum();
        System.out.println(sumValue);
        //求平均值
        double avgValue = appleList.stream().collect(Collectors.averagingInt(Apple::getWeight));
        System.out.println(avgValue);

        //joining
        String colors = appleList.stream().map(Apple::getColor).collect(Collectors.joining(","));
        System.out.println(colors);


        appleList.stream().collect(Collectors.reducing(0, Apple::getWeight, (a1, a2) -> a1 + a2));
        appleList.stream().map(Apple::getWeight).reduce(0, (a1, a2) -> a1 + a2);
        appleList.stream().map(Apple::getWeight).reduce(0, Integer::sum);


        appleList.stream().collect(Collectors.reducing((a1, a2) -> a1.getWeight() > a2.getWeight() ? a1 : a2));
        appleList.stream().map(Apple::getWeight).reduce((a1, a2) -> a1 > a2 ? a1 : a2);

        appleList.stream().collect(Collectors.reducing("", Apple::getColor, (a1, a2) -> a1.concat(a2)));
        appleList.stream().map(Apple::getColor).reduce("", String::concat);

        Map<String, List<Apple>> map0 = appleList.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(map0);
        Map<String, Map<String, List<Apple>>> map = appleList.stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.groupingBy(Apple::getProductionPlace)));
        System.out.println(map);
        Map<String, Long> map1 = appleList.stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.counting()));
        System.out.println(map1);

        Map<Boolean, List<Apple>> mapPartion = appleList.stream().collect(Collectors.partitioningBy(a -> a.getPrice() > 0));
        System.out.println(mapPartion);
        Map<Boolean, Map<String, List<Apple>>> mapPartion2 = appleList.stream().collect(Collectors.partitioningBy(a -> a.getPrice() > 0, Collectors.groupingBy(Apple::getProductionPlace)));
        System.out.println(mapPartion2);



    }
}
