package com.lkf.parttern.adapter;

/**
 * 类适配器
 */
public class Adapter extends Adaptee implements Target {
    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    public void sampleOperation2() {
        System.out.println("【Adapter】-【sampleOperation2】-我是目标类方法");

    }

}
