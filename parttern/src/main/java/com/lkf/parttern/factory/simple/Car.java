package com.lkf.parttern.factory.simple;

import com.lkf.parttern.factory.ICar;

/**
 * @author kaifeng
 */
public class Car implements ICar {
    /**
     * 获取carName
     */
    @Override
    public String getCarName() {
        return "我是小轿车";
    }
}
