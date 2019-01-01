package com.lkf.parttern.facade;

/**
 * 外观对象
 *
 * @author kaifeng
 * @date 2018/12/31
 */
public class Facade {

    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public Facade() {
        systemA = new SystemA();
        systemB = new SystemB();
        systemC = new SystemC();
    }

    public void wrapOpration() {
        System.out.println(systemA.operationA());
        System.out.println(systemB.operationB());
        System.out.println(systemC.operationC());
    }
}
