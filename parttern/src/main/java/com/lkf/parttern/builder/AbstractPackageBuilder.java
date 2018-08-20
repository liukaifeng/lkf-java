package com.lkf.parttern.builder;

/**
 * 肯德基套餐构造器（抽象建造者）
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public abstract class AbstractPackageBuilder {
    /**
     * 套餐对象
     */
    protected KFCPackage kfcPackage;

    public KFCPackage getKfcPackage() {
        return kfcPackage;
    }

    public void createKfcPackage() {
        kfcPackage = new KFCPackage();
    }

    /**
     * 构造食物
     */
    public abstract void buildFood();

    /**
     * 构造饮料
     */
    public abstract void buildDrink();
}
