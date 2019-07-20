package com.lkf.jdk8.lambda;

import com.lkf.jdk8.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * lambda 表达式类型推断
 *
 * @author lkf
 */
public class TypeInference {
    public static List<Apple> appleList = Arrays.asList(new Apple(60, "green"), new Apple(80, "yellow"), new Apple(200, "red"));

    public static void main(String[] args) {
        //需要类型推断，仅有一个参数需要类型推断时，参数两边的括号可以省略
        List<Apple> greenApple = appleList.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
        //需要类型推断
        Comparator<Apple> apple1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        //不需要类型推断
        Comparator<Apple> apple2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
        //使用方法引用的写法
        Comparator<Apple> apple3 = Comparator.comparing(Apple::getWeight);
    }
}
