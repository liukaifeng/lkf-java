package com.lkf.parttern.decorator;

/**
 * 具体对象
 *
 * @author kaifeng
 * @date 2018/12/31
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("【ConcreteComponent】具体对象的方法实现");
    }
}