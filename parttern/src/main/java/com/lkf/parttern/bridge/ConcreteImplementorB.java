package com.lkf.parttern.bridge;

/**
 * 实现类B
 *
 * @author kaifeng
 * @date 2018/12/23
 */
class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("我是具体实现类B");
    }
}
