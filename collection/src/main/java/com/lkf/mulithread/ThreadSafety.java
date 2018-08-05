package com.lkf.mulithread;

public class ThreadSafety {
    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "线程1");
        t1.start();
        Thread t2 = new Thread(pt, "线程2");
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        System.out.println("执行次数：" + pt.getCount());
    }

    static class ProcessingThread implements Runnable {
        private int count;

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                processSomething(i);
                count++;
            }
        }


        private void processSomething(int i) {
            // processing some job
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int getCount() {
            return this.count;
        }

    }
}
