package com.lkf.parttern.singleton;

/**
 * 饿汉式单例
 * <p>
 * 饿汉式是典型的空间换时间，当类装载的时候就会创建类的实例，
 * 不管你用不用，先创建出来，然后每次调用的时候，就不需要再判断，节省了运行时间。
 *
 * @author kaifeng
 */
public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    /**
     * 私有构造函数
     */
    private HungrySingleton() {
    }

    /**
     * 获取实例对象
     */
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
