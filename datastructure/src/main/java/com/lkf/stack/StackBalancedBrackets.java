package com.lkf.stack;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * @author lkf
 */
class StackBalancedBrackets {

    /**
     * @param s 字符串表达式
     * @return 如果匹配返回，true
     */
    private static boolean isBalanced1(String s) {
        Stack<Character> bracketsStack = new Stack<>();
        char[] text = s.toCharArray();
        for (char x : text) {
            switch (x) {
                case '{':
                case '<':
                case '(':
                case '[':
                    bracketsStack.push(x);
                    break;
                case '}':
                    if (bracketsStack.peek() == '{') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '>':
                    if (bracketsStack.peek() == '<') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (bracketsStack.peek() == '(') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (bracketsStack.peek() == '[') {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        return bracketsStack.empty();
    }

    //括号映射集合
    private final static HashMap<Character, Character> BRACKET_MAP = Maps.newHashMap();
    //括号左符号集合
    private final static Set<Character> BRACKET_KEY_SET = Sets.newHashSet();

    //初始化集合
    static {
        BRACKET_MAP.put('[', ']');
        BRACKET_MAP.put('{', '}');
        BRACKET_MAP.put('(', ')');
        BRACKET_MAP.put('<', '>');
        BRACKET_KEY_SET.addAll(BRACKET_MAP.keySet());
    }

    /**
     * 判断字符串中的括号是否平衡
     *
     * @param str 字符串
     * @return boolean
     * @author lkf
     * @date 2019/3/20 10:00
     */
    private static boolean isBalanced2(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (BRACKET_KEY_SET.contains(c)) {
                stack.push(c);
            }
            if (!stack.isEmpty() && BRACKET_MAP.get(stack.peek()) == c) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        String s = "({[9*9]})";
        if (isBalanced2(s)) {
            System.out.println(s + " 表达式括号平衡");
        } else {
            System.out.println(s + " 表达式括号不平衡");
        }
    }
}
