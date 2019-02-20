package com.lkf.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/1/26
 */
public class Java8Guide {
    public static void main(String[] args) {
        //lambda expressions
        List<String> fruits = Arrays.asList("orange", "watermelon", "banana", "apple");

        //before java 8
        Collections.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //java 8
        Collections.sort(fruits,(String a,String b)->b.compareTo(a));
        Collections.sort(fruits,(a,b)->a.compareTo(b));
        Collections.sort(fruits,String::compareTo);

        System.out.println(String.valueOf(fruits));
    }
}
