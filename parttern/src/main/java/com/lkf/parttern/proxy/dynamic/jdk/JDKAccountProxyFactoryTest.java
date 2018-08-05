package com.lkf.parttern.proxy.dynamic.jdk;

import com.lkf.parttern.proxy.dynamic.Account;
import com.lkf.parttern.proxy.dynamic.AccountImpl;

/**
 * jdk动态代理测试
 */
public class JDKAccountProxyFactoryTest {
    public static void main(String[] args) {
        Account account = (Account) new JDKAccountProxyFactory().bind(new AccountImpl());
        account.queryAccountBalance();
        System.out.println("***************************");
        account.updateAccountBalance();
    }
}
