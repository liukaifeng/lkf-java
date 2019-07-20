package com.lkf.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * java.util.function.Function<T, R>定义了一个叫apply的抽象方法，它接受一个泛型T的对象，并返回一个泛型R对象
 */
public class FunctionDemo {
    public static void main(String[] args) {
        //计算集合中的每一个元素的长度
        List<Integer> strLength = map(Arrays.asList("hello,world", "lambda"), s -> s.length());
        System.out.println(strLength);

    }

    /**
     * 遍历 list 并转换每一个元素，返回转换后的集合
     *
     * @param list     被操作对象集合
     * @param function 转换表达式
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}
