package leetcode;

/**
 * nowcoder
 * 链表分割
 * 编写代码，以给定值x为基准将链表分割成两部分，
 * 所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，
 * 请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变。
 */

/**
 * 创建两个新的链表
 * 判断后,通过尾插的方法进入链表
 * 遍历完链表后,将第一个链表的尾和第二个链表的头连接在一起
 */
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode cur = pHead;
        while (cur != null) {
            if (x <= cur.val) {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            } else {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    public ListNode partition2(ListNode pHead, int x) {
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        for (ListNode cur = pHead; cur != null; cur = cur.next) {  //两个代码的区别就在 一个用的while  一个用的for
            if (x <= cur.val) {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            } else {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
