package com.lkf.parttern.complex;

/**
 * todo 一句话描述该类的用途
 *
 * @author 刘凯峰
 * @date 2018-12-05 16-49
 */
public class StragetyContext {

    private Object obj = null;

    public StragetyContext( String className ) {
        try {
            Class<?> clazz = Class.forName("com.lkf.parttern.complex.".concat(className));
            obj = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public String getResult( String say ) {
        return ((IStragety) obj).sayHello(say);
    }

}
