package com.lkf.basic;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;

public class FinalDemo {
    public static void main(String[] args) {
        final ArrayList<String> strList = new ArrayList<String>();
        strList.add("Hello");
        strList.add("world");
        List<String> unmodifiableStrList = List.of("hello", "world");
        unmodifiableStrList.add("again");
    }
}
