package com.lkf.basic;

public class BankDemo {
    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("存钱 500 元....");
        c.deposit(500.00);
        try {
            System.out.println("\n取钱 100 元...");
            c.withdraw(100.00);
            System.out.println("\n取钱 600 元...");
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            System.out.println("很抱歉您的余额不足，差："
                    + e.getAmount());
            e.printStackTrace();
        }
    }
}
