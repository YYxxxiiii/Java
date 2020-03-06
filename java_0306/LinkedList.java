

public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = size(head);
        if (k <= 0 || k > size) {
            // k 是非法值
            return null;
        }
        int steps = size - k;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            // l1 为空, 最终结果就是 l2
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                // 把 cur1 对应的节点插入到新链表的末尾
                // 此处需要考虑到两种情况, newTail 为 null 和非 null 的情况.
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            } else {
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        // 当循环结束时, 意味着当前 cur1 和 cur2 一定有一个到达了链表末尾.
        // 把另外一个没到末尾的剩下的元素都连接在最终链表的尾部
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        return newHead.next;
    }