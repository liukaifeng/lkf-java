package com.lkf;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/2
 */
public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        Child child = new Child();
        child.parentMethod();
    }
}
