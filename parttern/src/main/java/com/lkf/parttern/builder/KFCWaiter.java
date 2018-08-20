package com.lkf.parttern.builder;

/**
 * 肯德基点餐员（指挥者）
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public class KFCWaiter {
    private AbstractPackageBuilder packageBuilder;
    public void setPackageBuilder(AbstractPackageBuilder packageBuilder){
        this.packageBuilder=packageBuilder;
    }

    public KFCPackage getKfcPackage(){
       return packageBuilder.getKfcPackage();
    }

    public void constructPackage() {
        packageBuilder.createKfcPackage();
        packageBuilder.buildFood();
        packageBuilder.buildDrink();

    }
}
