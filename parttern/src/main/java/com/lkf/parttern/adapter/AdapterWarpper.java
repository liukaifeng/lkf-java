package com.lkf.parttern.adapter;

/**
 * 对象适配器
 */
public class AdapterWarpper implements Target {
    private Adaptee adaptee;

    public AdapterWarpper(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 源类Adaptee有方法sampleOperation1
     * 因此适配器类直接委派即可
     */
    public void sampleOperation1() {
        this.adaptee.sampleOperation1();
    }

    /**
     * 源类Adaptee没有方法sampleOperation2
     * 因此由适配器类需要补充此方法
     */
    public void sampleOperation2() {
        System.out.println("【AdapterWarpper】-【sampleOperation2】-我是目标类方法");
    }
}
