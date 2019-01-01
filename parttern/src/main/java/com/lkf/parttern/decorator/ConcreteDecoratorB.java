package com.lkf.parttern.decorator;

/**
 * 具体装饰器实现类 B
 *
 * @author kaifeng
 * @date 2018/12/31
 */
public class ConcreteDecoratorB extends Decorator {


    @Override
    public void operation() {
        super.operation();
        methodB();
        System.out.println("【ConcreteDecoratorB】具体装饰对象 B 的独有操作");
    }

    private void methodB() {
        System.out.println("【ConcreteDecoratorB】我是具体装饰对象 B 的特有方法");
    }
}
