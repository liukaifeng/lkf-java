package com.lkf.parttern.builder;

/**
 * 构造器模式测试
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public class BuilderDemo {
    public static void main(String[] args) {
        //实例化点餐员对象（指挥者）
        KFCWaiter kfcWaiter = new KFCWaiter();

        //实例化产品套餐
        AbstractPackageBuilder packageBuilderA = new KFCPackageBuilderA();
        AbstractPackageBuilder packageBuilderB = new KFCPackageBuilderB();

        //构造A套餐
        kfcWaiter.setPackageBuilder(packageBuilderA);
        kfcWaiter.constructPackage();
        KFCPackage kfcPackageA = kfcWaiter.getKfcPackage();
        System.out.println(kfcPackageA.toString());

        //构造B套餐
        kfcWaiter.setPackageBuilder(packageBuilderB);
        kfcWaiter.constructPackage();
        KFCPackage kfcPackageB = kfcWaiter.getKfcPackage();
        System.out.println(kfcPackageB.toString());
    }
}
