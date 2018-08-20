package com.lkf.parttern.factory.abstrac;

import com.lkf.parttern.factory.ICar;
import com.lkf.parttern.factory.simple.CarType;

/**
 * 抽象工厂demo
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public class AbatractFactoryDemo {
    public static void main(String[] args) {
        //获取产品工厂
        AbstractCarFactory abstractCarFactory = AbstractFactoryProducer.getFactory("car");

        //获取产品为car的对象
        ICar car = abstractCarFactory.getCar(CarType.CAR);
        System.out.println(car.getCarName());

        //获取产品为bus的对象
        ICar bus = abstractCarFactory.getCar(CarType.BUS);
        System.out.println(bus.getCarName());

        //获取产品为SUV的对象
        ICar suv = abstractCarFactory.getCar(CarType.SUV);
        System.out.println(suv.getCarName());
    }
}
