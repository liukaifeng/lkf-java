package com.lkf.linkedlist;

/**
 * 返回链表倒数第n个元素
 *
 * @author 刘凯峰
 * @date 2019-03-06 17-59
 */
public class LinkedListBackN {
    public LinkedSingleListNode findElem( LinkedSingleListNode head, int k){
        if(k<1 || head == null)
        {
            return null;
        }
        LinkedSingleListNode p1 = head;
        LinkedSingleListNode p2 = head;
        for (int i = 0; i < k - 1; i++) {
            if(p1.getNext() != null){
                p1 = p1.getNext();
            }else {
                return null;
            }

        }
        while (p1 != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return p2;
    }

}
