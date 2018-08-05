package com.lkf.parttern.singleton;

/**
 * 在这个类级内部类里面去创建对象实例，只要不使用到这个类级内部类，
 * 那就不会创建对象实例，从而同时实现延迟加载和线程安全。
 *
 * @author kaifeng
 */
public class Singleton {
    private Singleton() {
    }

    /**
     * 类级的内部类，就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用时才会装载，从而实现了延迟加载。
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
