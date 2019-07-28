package com.lkf.jdk8.defaultmethod;

public interface Moveable {
    default void move(){
        System.out.println("I am moving");
    }
}
