package com.lkf.parttern.bridge;

/**
 * 抽象类
 *
 * @author kaifeng
 * @date 2018/12/23
 */
abstract class Abstraction {
    /**
     * 持有一个 Implementor 对象
     */
    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 调用实现的具体方法
     */
    public void operation() {
        implementor.operationImpl();
    }
}
