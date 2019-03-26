package com.lkf.linkedlist;

/**
 * 单链表节点
 *
 * @author 刘凯峰
 * @date 2019-03-06 17-28
 */
public class LinkedSingleListNode {
    /**
     * 当前节点数据
     */
    private int data;
    /**
     * 指向下一个节点
     */
    private LinkedSingleListNode next;


    public LinkedSingleListNode( int data ) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData( int data ) {
        this.data = data;
    }

    public LinkedSingleListNode getNext() {
        return next;
    }

    public void setNext( LinkedSingleListNode next ) {
        this.next = next;
    }
}
