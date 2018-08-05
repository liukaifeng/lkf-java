package com.lkf.collection.map;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("x", "1");
        map.put("x", "2");
        map.get("x");


        System.err.println(roundUpToPowerOf2(3));

    }

    private static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
        int MAXIMUM_CAPACITY = 1 << 30;
        return number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
    }

}
