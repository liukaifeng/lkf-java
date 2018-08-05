package com.lkf.parttern.singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 * @author kaifeng
 */
public class DCLSingleton {

    private volatile static DCLSingleton instance;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        //第一次检查实例是否存在，如果不存在才进入下面的同步块，否则直接返回实例
        if (instance == null) {
            //同步代码块，线程安全的创建实例
            synchronized (DCLSingleton.class) {
                //第二次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
