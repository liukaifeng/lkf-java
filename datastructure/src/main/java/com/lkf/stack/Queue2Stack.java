//package com.lkf.stack;
//
//import java.util.Queue;
//import java.util.concurrent.ArrayBlockingQueue;
//
///**
// * 2.队列实现栈
// * <p>
// * 思路同上：有数据队列和辅助队列，模拟栈的先进后出，队列是队尾进队头出，也就是说每次取值要取队列的队尾元素，数据队列出队到辅助队列，留下最后一个元素返回，辅助队列再把元素出队到数据队列
// *
// * @author kaifeng
// * @date 2019/3/5
// */
//public class Queue2Stack {
//    /**
//     * 用队列的入队和出队
//     * 来实现栈的入栈和出栈
//     */
////主要存放数据
//    Queue queue1 = ;
//    //辅助
//    Queue queue2 = new ArrayBlockingQueue();
//
//    public void push(Object o) {
//        queue1.add(o);
//    }
//
//    public Object pop() {
//        Object o = null;
//        while (queue1.size() > 1) {
//            queue2.add(queue1.poll());
//        }
//        if (queue1.size() == 1) {
//            o = queue1.poll();
//            while (queue2.size() > 0) {
//                queue1.add(queue2.poll());
//            }
//        }
//
//        return o;
//    }
//
//    public int length() {
//        return queue1.size();
//    }
//
//    public static void main(String[] args) {
//        /**
//         * 用两个队列实现栈
//         * */
//        Queue2Stack queue2Stack = new Queue2Stack();
//        queue2Stack.push("a");
//        queue2Stack.push("c");
//        queue2Stack.pop();
//        queue2Stack.push("d");
//        queue2Stack.push("e");
//        queue2Stack.push("f");
//        queue2Stack.push("g");
//        queue2Stack.push("h");
//
//        while (queue2Stack.length() > 0) {
//            System.out.println(queue2Stack.pop());
//        }
//    }
//
//}
