package com.lkf;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/2
 */
public class Child extends Parent {

    @Override
    synchronized public void parentMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println(" 子线程 i=" + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
