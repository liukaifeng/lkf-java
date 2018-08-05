package com.lkf.lock;

public class Resource {
    public void doSomething() {
        //do some operation, DB read, write etc
        System.err.println("doSomething");
    }

    public void doLogging() {
        //logging, no need for thread safety
        System.err.println("doLogging");

    }
}
