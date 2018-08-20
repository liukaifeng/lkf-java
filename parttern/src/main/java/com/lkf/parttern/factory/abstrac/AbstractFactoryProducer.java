package com.lkf.parttern.factory.abstrac;

/**
 * 生成工厂对象
 *
 * @author kaifeng
 * @date 2018/8/19
 */
public class AbstractFactoryProducer {
    public static AbstractCarFactory getFactory(String factoryType) {
        if ("car".equalsIgnoreCase(factoryType)) {
            return new CarConcreteFactory();
        }
        return null;
    }
}
