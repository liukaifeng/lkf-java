package com.lkf.parttern.proxy;

/**
 * 代理模式——真实对象角色
 * 业务的真正实现
 */
public class RealSubject implements Subject {
    /**
     * 请求方法
     */
    public void request(String param) {
        System.out.println("【RealSubject::request】-真实的业务实现:" + param);
    }
}
