package com.lkf.stack;

import java.util.Stack;

/**
 * 栈实现符号匹配检查
 *
 * @author kaifeng
 * @date 2019/3/5
 */
public class StackSymbolMatch {
    public static void main( String[] args ) {
        int flag = 1, l;
        String s = "{([])}";
        int num = s.length();
        char[] arr = s.toCharArray();
        //打印输出
        System.out.println(arr);
        // Stack<> stack;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < num; i++) {
            if ('{' == arr[i] || '(' == arr[i] || '[' == arr[i]) {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) {
                    flag = 1;
                } else {
                    if (('}' == arr[i] && stack.pop() == '{')
                            || ')' == arr[i] && stack.pop() == '('
                            || ']' == arr[i] && stack.pop() == '[') {
                        stack.pop();
                    }
                }
            }
        }
        if (flag == 1 && stack.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("NO");
        }
    }
}
