package com.lkf.parttern.singleton;

/**
 * 懒汉式单例
 * <p>
 * 这种单例是典型的时间换空间，只有使用的时候才会实例化，但是每次获取实例的时候都会进行判断，
 * 是否已经实例，花费了一些判断时间，如果一直没有使用就不会实例化，节省了内存空间
 *
 * @author kaifeng
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    /**
     * 私有构造函数
     */
    private LazySingleton() {
    }

    /**
     * 静态工厂方法，实例化对象
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
