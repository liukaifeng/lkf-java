package com.lkf.mulithread;

public class Waiter implements Runnable {
    private Message msg;

    public Waiter(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try {
                System.out.println(name + " 正在等待唤醒:" + System.currentTimeMillis());
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " 已被唤醒:" + System.currentTimeMillis());
            //process the message now
            System.out.println(name + " 消息处理完成: " + msg.getMsg());
        }
    }

}
