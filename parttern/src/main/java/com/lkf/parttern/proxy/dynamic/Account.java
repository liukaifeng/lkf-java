package com.lkf.parttern.proxy.dynamic;

/**
 * 账户操作接口
 *
 * @author kaifeng
 */
public interface Account {

    /**
     * 查询余额
     */
    void queryAccountBalance();

    /**
     * 充值话费
     */
    void updateAccountBalance();
}
