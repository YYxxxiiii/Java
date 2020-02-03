package java15_0107;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

public class LinkListOJ {
    public ListNode reverseList(ListNode head) {
        // 1. 空链表
        if (head == null) {
            return null;
        }
        // 2. 只有一个元素
        if (head.next == null) {
            return head;
        }
        // 3. 处理一般的情况
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            // 一会需要修改 cur.next, 需要提前记录好下一个元素的位置
            ListNode next = cur.next;
            if (next == null) {
                // 当前 cur 已经是最后一个节点了
                // cur 就是逆置之后的新的头结点
                newHead = cur;
            }
            cur.next = prev;
            // 同步更新 prev 和 cur 的位置, 准备操作下一个元素
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int steps = getSize(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private int getSize(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 需要保证 k 不能非法(超出范围)
        int size = getSize(head);
        if (k <= 0 || k > size) {
            return null;
            
        }
        // 获取到要让引用走的步数
        int offset = size - k;
        ListNode cur = head;
        for (int i = 0; i < offset; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
