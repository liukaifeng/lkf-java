package com.lkf.parttern.proxy;

/**
 * 代理模式——代理对象角色
 * 实现被代理对象的接口并包含真实对象
 */
public class Proxy implements Subject {
    private RealSubject realSubject;


    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    /**
     * 前置处理
     */
    public void preRequest() {
        System.out.println("【Proxy::preRequest】-前置处理");
    }

    /**
     * 请求方法
     */
    public void request(String param) {
        preRequest();
        realSubject.request(param);
        postRequest();
    }

    /**
     * 后置处理
     */
    public void postRequest() {
        System.out.println("【Proxy::postRequest】-后置处理");
    }
}
