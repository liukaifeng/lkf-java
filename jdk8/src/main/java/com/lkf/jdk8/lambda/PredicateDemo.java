package com.lkf.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        //非空字符串判断，lambda表达式
        Predicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
        //过滤非空字符串，lambda表达式作为参数传递
        List<String> nonEmptyStringLis = filter(Arrays.asList("hello", "world", ""), nonEmptyStringPredicate);
        System.out.println(nonEmptyStringLis);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (predicate.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
}
