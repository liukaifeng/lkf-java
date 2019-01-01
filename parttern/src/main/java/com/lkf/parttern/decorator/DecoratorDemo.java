package com.lkf.parttern.decorator;

/**
 * 装饰器客户端测试
 *
 * @author kaifeng
 * @date 2018/12/31
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

        concreteDecoratorA.SetComponent(concreteComponent);
        concreteDecoratorB.SetComponent(concreteDecoratorA);
        concreteDecoratorB.operation();
    }
}
