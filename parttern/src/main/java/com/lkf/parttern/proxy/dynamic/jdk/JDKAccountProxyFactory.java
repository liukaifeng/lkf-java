package com.lkf.parttern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 这里使用的是Jdk的动态代理，其必须实现接口，这也是jdk代理的缺陷，不过cglib代理会修补这个缺陷
 *
 * @author kaifeng
 */
public class JDKAccountProxyFactory implements InvocationHandler {

    private Object target;

    /**
     * 代理方式实例化对象
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean objFlag = method.getDeclaringClass().getName().equals("java.lang.Object");

        Object result = null;
        if (!objFlag) {
            System.out.println("【JDKAccountProxyFactory::invoke】-代理before");
        }
        //真实方法调用
        result = method.invoke(this.target, args);
        if (!objFlag) {
            System.out.println("【JDKAccountProxyFactory::invoke】-代理after");
        }
        return result;
    }
}

