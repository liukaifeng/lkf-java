package com.lkf.mulithread;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {

    // SimpleDateFormat不是线程安全的，所以每个对象引用一个
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

//    private static final ThreadLocal<SimpleDateFormat> formatter2 =
//            ThreadLocal.withInitial
//                    (() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(threadLocalExample, "Thread" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("线程：" + Thread.currentThread().getName() + " 默认时间格式： " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //时间格式在此更改，但是不会影响到其它线程
        formatter.set(new SimpleDateFormat());

        System.out.println("线程：" + Thread.currentThread().getName() + " 时间格式：" + formatter.get().toPattern());
    }

}
