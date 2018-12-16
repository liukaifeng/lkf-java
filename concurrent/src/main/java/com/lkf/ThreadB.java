package com.lkf;

import java.util.Random;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/2
 */
public class ThreadB extends Thread {
    private Class1 class1;

    public ThreadB(Class1 class1) {
        this.class1 = class1;
    }

    @Override
    public void run() {
        class1.testMethod();
    }
}
