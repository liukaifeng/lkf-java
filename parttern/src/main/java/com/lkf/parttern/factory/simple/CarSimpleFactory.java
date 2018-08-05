package com.lkf.parttern.factory.simple;

import com.lkf.parttern.factory.ICar;

/**
 * 简单工厂类
 *
 * @author kaifeng
 */
public class CarSimpleFactory {
    public ICar getCar(CarType carType) throws Exception {
        switch (carType) {
            case CAR:
                return new Car();
            case BUS:
                return new Bus();
            case SUV:
                return new Suv();
            default:
                throw new Exception("爱上了豪车，可是买不起啊！");
        }
    }
}
