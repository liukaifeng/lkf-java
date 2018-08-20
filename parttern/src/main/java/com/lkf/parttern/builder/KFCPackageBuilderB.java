package com.lkf.parttern.builder;

/**
 * B套餐构造器（具体建造者）
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public class KFCPackageBuilderB extends AbstractPackageBuilder {
    /**
     * 构造食物
     */
    @Override
    public void buildFood() {
        kfcPackage.setFood("B-半鸡半虾堡");
    }

    /**
     * 构造饮料
     */
    @Override
    public void buildDrink() {
        kfcPackage.setDrink("B-咖啡");
    }
}
