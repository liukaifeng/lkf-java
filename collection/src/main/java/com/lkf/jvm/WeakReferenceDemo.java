package com.lkf.jvm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        User user = new User("make", 19);//强引用
        WeakReference<User> reference = new WeakReference<User>(user);
        System.out.println(reference.get());
        System.gc();//通知垃圾收集器回收资源
        System.out.println(reference.get());
    }

    @Data
    @AllArgsConstructor
    public static class User {
        private String name;
        private int age;
    }
}
