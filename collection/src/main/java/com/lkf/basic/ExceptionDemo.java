package com.lkf.basic;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            divideOperation();
        } catch (ArithmeticException ae) {
            System.out.println("异常捕获，处理异常");
        }
        System.out.println("我是catch块后边的程序，异常处理后，我继续执行");
    }

    public static void divideOperation() {
        int a = 5 / 0;  //异常抛出点
        System.out.println("出现异常啦，方法被终止了，我躺着中枪了"); //不会执行
    }
}
