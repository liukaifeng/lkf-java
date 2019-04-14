package com.lkf.collection.sortedmap;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/13
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        method3();
    }

    private static void method1() {
        //key的自然顺序排序
//        SortedMap<String, PersonDetail> personMap = new TreeMap<>();
        //key的长度排序
        SortedMap<String, PersonDetail> personMap = new TreeMap<>((s1, s2) -> s2.length() - s1.length());
        personMap.put("zhangsan", new PersonDetail("张三", LocalDate.of(1998, 6, 22), "小胡同3号"));
        personMap.put("lisi", new PersonDetail("李四", LocalDate.of(1996, 2, 2), "小胡同8号"));
        personMap.put("wanger", new PersonDetail("王二", LocalDate.of(2010, 12, 11), "小胡同28号"));

        personMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void method2() {
//        //普通map
//        Map<String, PersonDetail> generalMap = new HashMap<>();
//        generalMap.put("lilei", new PersonDetail("李雷", LocalDate.of(1994, 6, 22), "1号大街"));
//        generalMap.put("hanmeimei", new PersonDetail("韩梅梅", LocalDate.of(1995, 2, 2), "2号大街"));
//        generalMap.put("zhangmeili", new PersonDetail("张美丽", LocalDate.of(2010, 12, 11), "3号大街"));
//        //普通map作为SortedMap构造函数的参数
//        SortedMap<String, PersonDetail> sortedMap = new TreeMap<>(generalMap);
//        System.err.println("普通map作为SortedMap构造函数的参数：");
//        sortedMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        //指定比较器的map
        Map<String, PersonDetail> sortedComparetorMap = new TreeMap<>((s1, s2) -> s2.length() - s1.length());
        sortedComparetorMap.put("lilei", new PersonDetail("李雷", LocalDate.of(1994, 6, 22), "1号大街"));
        sortedComparetorMap.put("hanmeimei", new PersonDetail("韩梅梅", LocalDate.of(1995, 2, 2), "2号大街"));
        sortedComparetorMap.put("zhangmeili", new PersonDetail("张美丽", LocalDate.of(2010, 12, 11), "3号大街"));
//        System.err.println("根据key长度排序的sortedComparetorMap：");
//        sortedComparetorMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        System.err.println("指定比较器的有序map作为SortedMap构造函数的参数：");
        SortedMap<String, PersonDetail> newMap = new TreeMap<>(sortedComparetorMap);
        newMap.forEach((key, value) -> System.out.println(key + " -> " + value));

    }

    private static void method3() {
        SortedMap<String, PersonDetail> personMap = new TreeMap<>((s1, s2) -> s2.length() - s1.length());
        personMap.put("zhangsan", new PersonDetail("张三", LocalDate.of(1998, 6, 22), "小胡同3号"));
        personMap.put("lisi", new PersonDetail("李四", LocalDate.of(1996, 2, 2), "小胡同8号"));
        personMap.put("wanger", new PersonDetail("王二", LocalDate.of(2010, 12, 11), "小胡同28号"));

        System.out.println("映射关系如下：===================");
        personMap.forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("===================");

        System.out.println("entrySet:" + personMap.entrySet());
        System.out.println("firstKey:" + personMap.firstKey());
        System.out.println("lastKey:" + personMap.lastKey());
        System.out.println("keySet:" + personMap.keySet());
        System.out.println("values:" + personMap.values());
        System.out.println("headMap(\"wanger\"):" + personMap.headMap("wanger"));
        System.out.println("tailMap(\"wanger\"):" + personMap.tailMap("wanger"));

    }
}
