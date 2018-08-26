package com.lkf.parttern.prototype;

/**
 * 抽象原型类
 *
 * @author kaifeng
 * @date 2018/8/26
 */
public abstract class Prototype implements Cloneable {

    /**
     * 获取名称
     *
     * @return
     */
    public abstract String getName();

    /**
     * 抽象拷贝方法
     *
     * @return Object
     * @throws CloneNotSupportedException
     */
    public abstract Object copy() throws CloneNotSupportedException;

}
