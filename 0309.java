
public class LinkedListTest {
    // 给内部类加 static 效果和其他的 static 类似. 让这个类和 LinkedListTest 类相关, 而和对象不相关.
    // 后续如果要创建 ListNode 的实例的话, 就不需要依赖 LinkedListTest 的实例
    static class ListNode {
        int val;
        ListNode next;

        // alt + insert 弹出一个下拉菜单, 选择生成构造方法.
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 删除头部节点和删除中间节点, 逻辑不一样.
        // 需要分别对待.
        if (head == null) {
            // 空链表, 没的删
            return null;
        }
        // 1. 先删除中间节点的情况(非头部的情况)
        ListNode prev = head;  // prev 始终指向 cur 的前一个位置
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                // 这个节点就需要删除掉
                prev.next = cur.next; // 这一行代码下来, cur 对应的节点就被删掉了
                cur = prev.next;        // cur 指向下一个元素, 方便进行下次循环
            } else {
                // 这个节点不需要删除
                prev = cur;
                cur = cur.next;
            }
        }
        // 2. 最后再考虑删除头结点的情况(放到最后, 只需要处理一次即可)
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // 诸如链表为空等特殊情况一定要重点考虑到
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            // 空链表, 不需要逆置
            return null;
        }
        if (head.next == null) {
            // 链表中只有一个元素, 也不需要逆置
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 当前 cur 就是原链表的末尾
                newHead = cur;
            }
            // 逆置的核心操作
            cur.next = prev;
            // 更新三兄弟的指向位置
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    public ListNode middleNode(ListNode head) {
        int steps = size(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

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

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 插入到 smallTail 后面, 创建崭新的节点(新节点的 next 一定是 null)
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                // 插入到 bigTail 的后面
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }

        // 将两个链表收尾相接到一起
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    // 删除有序链表中的所有重复元素
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        // 循环遍历链表
        ListNode cur = pHead;
        while (cur != null) {
            // 判定 cur 是否是重复元素
            // 时刻牢记, 针对某个引用进行 . 操作的时候, 必须保证该引用不能是 null
            // 假设 cur 已经指向 最后一个元素了, cur.next 就是 null
            // 短路求值. 左侧表达式如果为 false, 右侧就不求值了(对于逻辑与来说)
            if (cur.next != null && cur.val == cur.next.val) {
                // 说明 cur 指向的元素就是重复元素, 接下来就需要找到这个重复元素区间的末尾
                // 最终能够跳过整个重复元素的区间
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 上面的 while 循环结束, 此时 cur 就指向这片相同元素区间的最后一个位置
                // 再多走一步就意味着跳过了整个相同元素的区间
                cur = cur.next;
            } else {
                // 说明 cur 指向的元素不是重复元素
                // 把这个元素插入到新链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public boolean chkPalindrome(ListNode A) {
        // 1. 先找到 A 链表的中间节点
        int size = size(A);
        int steps = size / 2;
        ListNode B = A;
        for (int i = 0; i < steps; i++) {
            B = B.next;
        }
        // 上面的循环结束后, B 就指向 A 链表的中间位置了
        // 2. 从 B 开始对后面的链表进行逆置操作
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 说明此时的 cur 已经是链表的最后一个节点了, 更新头结点的位置
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 3. 分别从 A 和 B 出发, 来依次对比两个链表的元素是否对应相等.
        // 如果链表的长度为 奇数 个, 那 A 和 B 长度是相同的, 此时无影响
        // 如果链表的长度为 偶数 个, 那 A 的长度比 B 要长一个元素, 就需要注意遍历的时候循环结束条件
        // 要以 B 为基准
        while (B != null) {
            if (A.val != B.val) {
                // 对应元素不同, 说明不是回文
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 分别求两个链表的长度
        int size1 = size(headA);
        int size2 = size(headB);
        // 2. 算出差值, 让长的链表先走
        if (size1 > size2) {
            int offset = size1 - size2;
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            int offset = size2 - size1;
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        // 3. 此时此刻, headA 和 headB 已经在同一起跑线了
        while (headA != null && headB != null) {
            // 比较的是节点是不是相同对象(比较身份)
            if (headA == headB) {
                // 如果相同节点, 认为这个位置就是链表的交点
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        // 链表不相交
        return null;
    }

    public boolean hasCycle(ListNode head) {
        // 使用快慢指针的方式来判定
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            // 这个代码要求 fast.next 不能是 null
            fast = fast.next.next;
            if (slow == fast) {
                // 判定两个节点是否是相同节点
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        // 1. 使用快慢指针, 找到快慢指针的交点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 此时链表就是带环的
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // 链表不带环
            return null;
        }
        // 带环的情况, 设定两个引用, 分别从链表头部和fast slow交点出发, 按照相同的速度同步往后走
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 这个位置就是环的入口
        return cur1;
    }

  
    }
}
