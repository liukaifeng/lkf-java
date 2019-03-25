package com.lkf.linkedlist;

/**
 * 删除有序链表中的重复元素
 * 这是一个简单的问题，仅测试你操作列表的结点指针的能力。
 * 由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
 * 如果它是重复的，
 * 我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
 *
 * @author kaifeng
 * @date 2019/3/24
 */
public class LinkedListDeduplication {
    /**
     * 递归实现
     * 递归套路解决链表问题：
     * <p>
     * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
     * <p>
     * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
     * <p>
     * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，
     * 而根据第二步，我应该返回一个去重的链表的头节点。
     * 因此这一步应该做的是判断当前的head和head.next是否相等，
     * 如果相等则说明重了，返回head.next，否则返回head
     */
    public LinkedSingleListNode deleteDuplicates1(LinkedSingleListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        head.setNext(deleteDuplicates1(head.getNext()));
        if (head.getData() == head.getNext().getData()) {
            head = head.getNext();
        }
        return head;
    }

    /**
     * 循环实现
     */
    public LinkedSingleListNode deleteDuplicates2(LinkedSingleListNode head) {
        LinkedSingleListNode p = head;
        while (p != null && p.getNext() != null) {
            if (p.getData() == p.getNext().getData()) {
                p.setNext(p.getNext().getNext());
            } else {
                p = p.getNext();
            }
        }
        return head;
    }
}
