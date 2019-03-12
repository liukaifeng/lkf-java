package com.lkf.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/3/9
 */
public class AtomicIntegerFieldUpdaterTest {
    //创建原子更新器，并设置需要更新的对象及属性
    private static AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) {
        User user = new User("baby", 18);
        //baby长了一岁,输出 18
        System.out.println(updater.getAndIncrement(user));
        //输出19
        System.out.println(updater.get(user));
    }

    static class User {

        private String name;
        public volatile int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
