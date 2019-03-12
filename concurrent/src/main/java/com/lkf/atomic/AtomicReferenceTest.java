package com.lkf.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/3/9
 */
public class AtomicReferenceTest {
    private static AtomicReference<User> reference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("Jack", 21);
        reference.set(user);

        User updateUser = new User("Jonse", 28);
        reference.compareAndSet(user, updateUser);

        System.out.println(reference.get().getName());
        System.out.println(reference.get().getAge());
    }


    static class User {

        private String name;
        private int age;

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
