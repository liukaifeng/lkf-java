package com.lkf.parttern.factory.method;

import com.lkf.parttern.factory.ICar;

/**
 * 抽象工厂接口
 *
 * @author kaifeng
 */
public interface ICarFactory {
    /**
     * 创建抽象产品对象
     */
    ICar createCar();
}
