package com.lkf.jdk8.defaultmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Animal implements Moveable{
    public static void main(String[] args){
        List<Animal> list = new ArrayList();
        list.add(new Animal());
        list.add(new Animal());
        list.add(new Animal());

        list.forEach((Consumer<Moveable>) Moveable::move);
    }
}

interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    public static void main(String[] args) {
        new C().hello();
    }
}
