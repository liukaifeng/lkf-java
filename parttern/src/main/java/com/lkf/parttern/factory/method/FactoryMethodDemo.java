package com.lkf.parttern.factory.method;

import com.lkf.parttern.factory.ICar;

/**
 * 工厂方法测试
 *
 * @author kaifeng
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        ICarFactory factory = null;
        // car
        factory = new FactoryCar();
        ICar car = factory.createCar();
        System.out.println(car.getCarName());

        // bus
        factory = new FactoryBus();
        ICar bus = factory.createCar();
        System.out.println(bus.getCarName());

        // suv
        factory = new FactorySuv();
        ICar suv = factory.createCar();
        System.out.println(suv.getCarName());
    }
}
