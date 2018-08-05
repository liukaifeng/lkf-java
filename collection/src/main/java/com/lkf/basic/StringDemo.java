package com.lkf.basic;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "a" + "b" + "c";
        String str3 = new String("abc");
        String str4 = str3.intern();
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));
        System.out.println(str1.equals(str4));
        StringBuilder stringBuilder = new StringBuilder();
    }
}
