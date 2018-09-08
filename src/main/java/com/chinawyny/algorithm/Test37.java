package com.chinawyny.algorithm;

public class Test37 {

    private static ListNode func(ListNode l1, ListNode l2) {
        
        int len1 = 0;
        int len2 = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        while (temp1 != null) {
            temp1 = temp1.next;
            len1++;
        }
    
        while (temp2 != null) {
            temp2 = temp2.next;
            len2++;
        }
        
        int diff = len1 - len2;
        while (diff > 0) {
            l1 = l1.next;
            diff--;
        }
        
        while (diff < 0){
            l2 = l2.next;
            diff++;
        }
        
        while (l1 != null && l2 != null && l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 == null) {
            return null;
        }
        
        return l1;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
    
        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;
    
        n4.next = n5;
        n5.next = n6;
    
        System.out.println(func(n1, n4).val);
    }

}
