package com.lkf.parttern.factory.simple;

import com.lkf.parttern.factory.ICar;

/**
 * 简单工厂测试
 *
 * @author kaifeng
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        ICar car;
        try {
            //实例化简单工厂
            CarSimpleFactory factory = new CarSimpleFactory();
            //通过简单工厂实例化具体产品类
            car = factory.getCar(CarType.CAR);
            System.out.println(car.getCarName());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
