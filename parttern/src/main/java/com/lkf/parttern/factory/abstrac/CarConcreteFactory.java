package com.lkf.parttern.factory.abstrac;

import com.lkf.parttern.factory.ICar;
import com.lkf.parttern.factory.simple.Bus;
import com.lkf.parttern.factory.simple.Car;
import com.lkf.parttern.factory.simple.CarType;
import com.lkf.parttern.factory.simple.Suv;

/**
 * 具体实现工厂
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public class CarConcreteFactory extends AbstractCarFactory {
    /**
     * 获取相应的car对象
     *
     * @param carType car类型
     * @return ICar
     */
    @Override
    public ICar getCar(CarType carType) {
        if (carType == CarType.CAR) {
            return new Car();
        }
        if (carType == CarType.BUS) {
            return new Bus();
        }
        if (carType == CarType.SUV) {
            return new Suv();
        }
        return null;
    }
}
