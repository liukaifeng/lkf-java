package com.lkf.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 行为参数化
 */
public class BehavioralParam {
    //构造数据
    public static List<Apple> appleList = Arrays.asList(new Apple(60, "green"), new Apple(80, "yellow"), new Apple(200, "red"));

    public static void main(String[] args) {
//        System.out.println(filterGreenApples(appleList));
//        System.out.println(filterApplesByColor(appleList,"red"));
//        System.out.println(filterApplesByParam(appleList, "red", 80));
//        System.out.println(filterApplesByParam(appleList,  new AppleWeightPredicate()));
//        filter(appleList,(Apple apple)->"red".equals(apple.getColor()));
//        filter(Arrays.asList(10,55,12,41),i->i%2==0);
        List<Integer> list = Arrays.asList(9, 3, 11, 5, 7, 2, 9);
        System.out.println(appleList);
        appleList.sort((Apple apple1, Apple apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));

        appleList.sort(Comparator.comparing(Apple::getWeight));

        List<Apple> weightThan150g = filter(appleList, (Apple a) -> a.getWeight() > 150);
    }

    /**
     * 筛选绿色的苹果
     *
     * @param appleList 苹果集合对象
     */
    public static List<Apple> filterGreenApples(List<Apple> appleList) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选指定颜色的苹果
     *
     * @param appleList 苹果集合对象
     * @param color     苹果颜色
     */
    public static List<Apple> filterApplesByColor(List<Apple> appleList, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选指定颜色的苹果
     *
     * @param appleList 苹果集合对象
     * @param color     苹果颜色
     * @param weight    苹果重量
     */
    public static List<Apple> filterApplesByParam(List<Apple> appleList, String color, int weight) {
        // 符合条件的苹果集合
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            // 如果颜色和重量符合条件就存入
            if (color.equalsIgnoreCase(apple.getColor()) && weight == apple.getWeight()) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选苹果
     *
     * @param appleList      苹果集合对象
     * @param applePredicate 行为参数化，苹果抽象谓词判断对象
     */
    public static List<Apple> filter(List<Apple> appleList, ApplePredicate applePredicate) {
        // 符合条件的苹果集合
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * List 对象抽象化
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
