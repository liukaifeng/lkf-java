package com.lkf.parttern.complex;

/**
 * todo 一句话描述该类的用途
 *
 * @author 刘凯峰
 * @date 2018-12-05 16-54
 */
public class ClientDemo {
    public static void main( String[] args ) {
        StragetyContext context;
        String type = "OneStragety";
        String params = "I'm one";
        context = new StragetyContext(type);
        String result = context.getResult(params);
        System.out.println(result);
    }
}
