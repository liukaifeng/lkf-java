package com.lkf.parttern.singleton;

/**
 * @author kaifeng
 */
public enum EnumSingleton {
    /**
     * 定义一个枚举的元素，它就代表了Singleton的一个实例
     */
    instance;

    /**
     * 单例可以有自己的操作
     */
    public void singletonCustom() {
        //自定义操作
    }
}
