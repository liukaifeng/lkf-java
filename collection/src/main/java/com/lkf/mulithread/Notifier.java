package com.lkf.mulithread;

public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 已经启动");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name + " 我是一条消息");
//                msg.notify();
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}