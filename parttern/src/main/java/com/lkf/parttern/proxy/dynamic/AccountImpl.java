package com.lkf.parttern.proxy.dynamic;

/**
 * 账户操作实现
 *
 * @author kaifeng
 */
public class AccountImpl implements Account {
    /**
     * 查询余额
     */
    @Override
    public void queryAccountBalance() {
        System.out.println("【AccountImpl::queryAccountBalance】-查询账户余额");
    }

    /**
     * 充值话费
     */
    @Override
    public void updateAccountBalance() {
        System.out.println("【AccountImpl::updateAccountBalance】-话费充值");
    }
}
