package com.lkf.linkedlist;

/**
 * 检查链表中是否存在循环
 * 1 2 3 4 5
 * <p>
 * slow:1 fast:3
 * <p>
 * slow:2 fast:5
 * <p>
 * slow:3 fast:5
 * <p>
 * slow:4 fast:5
 * <p>
 * slow:5 fast:5
 *
 * @author 刘凯峰
 * @date 2019-03-06 17-27
 */
public class LinkedListLoopCheck {

    public static boolean hascycle( LinkedSingleListNode head ) {
        //快慢指针
        LinkedSingleListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main( String[] args ) {
        LinkedSingleListNode node1 = new LinkedSingleListNode(1);
        LinkedSingleListNode node2 = new LinkedSingleListNode(2);
        LinkedSingleListNode node3 = new LinkedSingleListNode(3);
        LinkedSingleListNode node4 = new LinkedSingleListNode(4);
        LinkedSingleListNode node5 = new LinkedSingleListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node4);

//        System.out.println(JSONObject.toJSONString(foreachReverse(node1)));

        System.out.println(hascycle(node1));

    }
}
