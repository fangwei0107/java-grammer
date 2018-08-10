package com.chinawyny.algorithm;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 查找中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        ListNode preTail = new ListNode(0);

        // 反转后半部分
        while (tail != null) {
            ListNode postTail = tail.next;
            tail.next = preTail.next;
            preTail.next = tail;
            tail = postTail;
        }

        // 将后半部分插入前半部分
        ListNode fontTemp = head;
        ListNode tailTemp = preTail.next;
        while (fontTemp != null && tailTemp != null) {
            ListNode nextFontTemp = fontTemp.next;
            ListNode nextTailTemp = tailTemp.next;
            tailTemp.next = fontTemp.next;
            fontTemp.next = tailTemp;
            fontTemp = nextFontTemp;
            tailTemp = nextTailTemp;
        }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        reorderList.reorderList(n1);
    }
}
