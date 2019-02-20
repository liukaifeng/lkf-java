package com.lkf.basic;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = new String("Hello World");
        String str3 = new String("Hello World");
        String str4 = "Hello World";
        System.out.println(str1 == str2); // false
        System.out.println(str2 == str3); // false
        System.out.println(str2.equals(str3)); // true
        System.out.println(str1 == str4); // true
        str4 = "Happy new year";
        String str5 = "Happy new year";
        System.out.println(str1 == str4); // false
        System.out.println(str4 == str5); // true
    }
}
