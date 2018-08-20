package com.lkf.parttern.builder;

/**
 * A套餐构造器（具体建造者）
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public class KFCPackageBuilderA extends AbstractPackageBuilder {
    /**
     * 构造食物
     */
    @Override
    public void buildFood() {
        kfcPackage.setFood("A-香辣鸡腿堡");
    }

    /**
     * 构造饮料
     */
    @Override
    public void buildDrink() {
        kfcPackage.setDrink("A-可口可乐（中杯）");
    }
}
