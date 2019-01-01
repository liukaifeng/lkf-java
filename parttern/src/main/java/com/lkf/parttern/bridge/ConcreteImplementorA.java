package com.lkf.parttern.bridge;

/**
 * 实现类A
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("我是具体实现类A");
    }
}


