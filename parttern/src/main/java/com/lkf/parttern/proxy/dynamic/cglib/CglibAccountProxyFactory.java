package com.lkf.parttern.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态生成代理对象
 *
 * @author kaifeng
 */
public class CglibAccountProxyFactory implements MethodInterceptor {

    private Object target;

    /**
     * 获取对象实例
     */
    public Object getInstance(Object target) {
        this.target = target;
        return Enhancer.create(this.target.getClass(), this);
    }

    /**
     * 方法拦截
     * <p>
     * 一般使用proxy.invokeSuper(obj,args)方法
     * proxy.invoke(obj,args)，这是执行生成子类的方法。
     * 如果传入的obj就是子类的话，会发生内存溢出，因为子类的方法不进入intercept方法，而这个时候又去调用子类的方法，两个方法直接循环调用了
     * </p>
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 排除Object类中的toString等方法
        System.out.println(method.getDeclaringClass().getName());
        boolean objFlag = method.getDeclaringClass().getName().equals("java.lang.Object");
        if (!objFlag) {
            System.out.println("【CglibAccountProxyFactory::intercept】-代理before");
        }
        Object result = null;
        result = methodProxy.invokeSuper(obj, args);
        if (!objFlag) {
            System.out.println("【CglibAccountProxyFactory::intercept】-代理after");
        }
        return result;
    }

}
