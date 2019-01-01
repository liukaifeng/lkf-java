package com.lkf.parttern.bridge;

/**
 * 客户端调用
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        //实例化具体实现
        Implementor implementor = new ConcreteImplementorA();
        //初始化扩充实现类
        RefinedAbstraction abstraction = new RefinedAbstraction(implementor);
        //通过扩充实现类调用具体方法
        abstraction.operation();
        //调用扩充实现类的扩充方法
        abstraction.otherOperation();
    }
}
