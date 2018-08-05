package com.lkf.basic;

//自定义异常类，继承Exception类
public class InsufficientFundsException extends Exception {
    //金额
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
