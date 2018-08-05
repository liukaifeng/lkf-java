package com.lkf.basic;

public class FinallyDemo {
    public static void main(String[] args) {
//        try {
//            // do something
//            System.exit(1);
//        } finally{
//            System.out.println("this is finally");
//        }
        System.out.println(test());

    }

    private static int test() {
        int a = 10, b = 0;
        try {
            System.out.println("this is try");
            return a / b;
        } catch (ArithmeticException ex) {
            System.err.println(ex);
            throw ex;
        } finally {
            System.out.println("this is finally");
        }
    }
}
