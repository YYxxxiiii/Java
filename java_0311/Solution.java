package java_0311;

import Java_0227.LinkedListTest;

import java.util.List;

public class Solution {
    static class ListNode {
        int val; //这是一个数据
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead,int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null){
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        for (ListNode cur = pHead;cur != null;cur = cur.next) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else{
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }


    public boolean chkPalindrome(ListNode A) {
        int size = size(A);
        int steps = size / 2;
        ListNode B = A;
        for (int i =0;i < steps;i++) {
            B = B.next;
        }
        ListNode prev = null;
        ListNode cur =B
    }
}
