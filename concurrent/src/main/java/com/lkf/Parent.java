package com.lkf;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/2
 */
public class Parent {
    public int i = 10;

    synchronized public void parentMethod() {
        try {
            i--;
            System.out.println(" 父线程 i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}