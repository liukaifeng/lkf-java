package com.lkf.mulithread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回当前线程名字
        return Thread.currentThread().getName();
    }

    public static void main(String args[]) {

        //使用Executors创建一个固定大小的线程池，线程池大小为10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //创建一个列表来保存与Callable相关的Future对象
        List<Future<String>> list = new ArrayList<Future<String>>();
        //创建 MyCallable 实例
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 100; i++) {
            //提交任务到线程池
            Future<String> future = executor.submit(callable);
            //将返回值放入集合
            list.add(future);
        }
        for (Future<String> fut : list) {
            try {

                //打印返回值，注意这时会有延时，因为Future.get()要等待任务完成
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //关闭线程池
        executor.shutdown();
    }

}
