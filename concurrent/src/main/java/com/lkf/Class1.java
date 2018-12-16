package com.lkf;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/2
 */
public class Class1 {
    synchronized public void method1() {
        System.out.println(" method1");
        method2();
    }

    synchronized public void method2() {
        System.out.println(" method2");
        method3();
    }

    synchronized public void method3() {
        System.out.println(" method3");
    }

    synchronized public void testMethod() {
        if (" a".equals(Thread.currentThread().getName())) {
            while (true) {
                System.out.println(" ThreadName=" + Thread.currentThread().getName() + " 执行开始时间=" + System.currentTimeMillis());
                System.out.println(" ThreadName=" + Thread.currentThread().getName() + " 出现异常" + System.currentTimeMillis());
                Integer.parseInt(" a");
            }
        } else {
            System.out.println(" Thread B 执行开始时间=" + System.currentTimeMillis());
        }
    }
}

