package com.lkf.parttern.factory.abstrac;

import com.lkf.parttern.factory.ICar;
import com.lkf.parttern.factory.simple.CarType;

/**
 * 抽象工厂
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public abstract class AbstractCarFactory {
    /**
     * 获取相应的car对象
     *
     * @param carType car类型
     * @return ICar
     */
    public abstract ICar getCar(CarType carType);
}
