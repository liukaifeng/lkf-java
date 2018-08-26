package com.lkf.parttern.prototype;

/**
 * 具体原型类Two
 *
 * @author kaifeng
 * @date 2018/8/26
 */
public class ConcretePrototypeTwo extends Prototype {
    private String name;

    public ConcretePrototypeTwo(String name) {
        this.name = name;
    }

    /**
     * 获取名称
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 抽象拷贝方法
     *
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object copy() throws CloneNotSupportedException {
        return super.clone();
    }
}
