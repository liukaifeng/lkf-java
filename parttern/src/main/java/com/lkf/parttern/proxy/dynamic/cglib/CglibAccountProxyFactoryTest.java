package com.lkf.parttern.proxy.dynamic.cglib;

import com.lkf.parttern.proxy.dynamic.Account;
import com.lkf.parttern.proxy.dynamic.AccountImpl;
import com.lkf.parttern.proxy.dynamic.SalesPerson;

/**
 * cglib动态代理测试
 *
 * @author kaifeng
 */
public class CglibAccountProxyFactoryTest {
    public static void main(String[] args) {
        // 下面是用cglib的代理
        // 1.支持实现接口的类
        Account account = (Account) new CglibAccountProxyFactory().getInstance(new AccountImpl());
        account.queryAccountBalance();

        // 2.支持未实现接口的类
        SalesPerson salesPerson = (SalesPerson) new CglibAccountProxyFactory().getInstance(new SalesPerson());
        System.out.println("我的工号是：" + salesPerson.getJobNum());
    }
}
