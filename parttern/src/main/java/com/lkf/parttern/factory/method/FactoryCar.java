package com.lkf.parttern.factory.method;

import com.lkf.parttern.factory.ICar;
import com.lkf.parttern.factory.simple.Car;

/**
 * 具体工厂对象
 *
 * @author kaifeng
 */
public class FactoryCar implements ICarFactory {

    /**
     * 创建抽象产品对象
     */
    @Override
    public ICar createCar() {
        return new Car();
    }
}
