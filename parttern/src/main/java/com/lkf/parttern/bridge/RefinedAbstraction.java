package com.lkf.parttern.bridge;

/**
 * 扩充实现类
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void otherOperation() {
        System.out.println("我是其它操作");
    }
}