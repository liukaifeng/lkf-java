package com.lkf.parttern.prototype;

/**
 * 原型模式测试
 *
 * @author kaifeng
 * @date 2018/8/26
 */
public class ProtoTypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new ConcretePrototypeTwo("two");
        System.out.println(p1.getName());

        Prototype p2 = (ConcretePrototypeTwo) p1.copy();
        System.out.println(p2.getName());
    }
}
