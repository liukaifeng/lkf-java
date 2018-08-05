package com.lkf.parttern.proxy;

/**
 * 代理模式-抽象对象接口
 */
public interface Subject {
    /**
     * 请求方法
     *
     * @param param 请求参数
     */
    void request(String param);
}
