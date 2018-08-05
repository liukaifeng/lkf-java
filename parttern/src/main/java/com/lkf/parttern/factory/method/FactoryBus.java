package com.lkf.parttern.factory.method;

import com.lkf.parttern.factory.ICar;
import com.lkf.parttern.factory.simple.Bus;

/**
 * @author kaifeng
 */
public class FactoryBus implements ICarFactory {
    /**
     * 创建抽象产品对象
     */
    @Override
    public ICar createCar() {
        return new Bus();
    }
}
