package com.lkf.stack;


import java.util.Stack;

/**
 * 将要排序的栈记为stack，申请的辅助栈记为help。在stack上执行pop操作，弹出的元素记为cur。
 * <p>
 *     （1）如果cur小于或等于help的栈顶元素，则将cur直接压入help；
 * <p>
 *      （2）如果cur大于help的栈顶元素，则将该help的元素逐个弹出，逐个压入stack栈，直到cur小于等于help的栈顶元素，再将 cur压入help。
 * <p>
 * <p>
 * 使用了两个栈和一个变量，把排序栈中的第一个元素压入辅助栈中，
 * 如果排序栈中新弹出的cur元素比辅助栈的元素大的话，就把辅助栈中的元素压回排序栈，把cur元素压入辅助栈中。不断重复此过程，辅助栈中的元素始终是从小到大排序。
 *
 * @author lkf
 */
public class StackByStackSort {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(6);
        stack.push(4);
        stack.push(9);
        stack.push(2);

        sortStackByStack(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}

