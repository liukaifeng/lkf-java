package com.lkf.parttern.decorator;

/**
 * 具体装饰器类 ConcreteDecoratorA
 *
 * @author kaifeng
 * @date 2018/12/31
 */
public class ConcreteDecoratorA extends Decorator {
    /**
     * ConcreteDecoratorA 独有功能属性，区别于ConcreteDecoratorB
     */
    private String concreteDecoratorA;

    @Override
    public void operation() {
        super.operation();
        concreteDecoratorA = "我是具体装饰对象 A 的特有功能";
        System.out.println("【ConcreteDecoratorA】".concat(concreteDecoratorA));
        System.out.println("【ConcreteDecoratorA】具体装饰对象 A 的独有操作");
    }
}
