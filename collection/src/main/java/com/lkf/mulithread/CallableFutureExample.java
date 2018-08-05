package com.lkf.mulithread;

import java.util.concurrent.*;

public class CallableFutureExample {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        //实例化任务
        MyTask task = new MyTask();
        //提交任务
        Future<Integer> result = executor.submit(task);
        //关闭线程池
        executor.shutdown();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("MyTask的返回值：" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

    static class MyTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在执行");
            Thread.sleep(5000);
            return 1000;
        }
    }
}
