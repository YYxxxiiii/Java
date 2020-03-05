package Java_0227;

public class LinkedListTest {
    // 给内部类加 static 效果和其他的 static 类似. 让这个类和 LinkedListTest 类相关, 而和对象不相关.
    // 后续如果要创建 ListNode 的实例的话, 就不需要依赖 LinkedListTest 的实例
    static class ListNode {
        int val; //这是一个数据
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //先不考虑头结点
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) { //cur.val里的这个val是内部类ListNode里的那个数据,后面那个val是要删除的数据
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        //头结点来了
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }


    //反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) { //空链表情况
            return null;
        }
        if (head.next == null) {  //链表中只有一个元素
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null; //prev是自己创建的一个新的结点
        while(cur != null) {
            ListNode next = cur.next;
            if (next == null) {  //当前cur就是原链表的末尾
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }


    // 返回非空链表的中间结点
    //先写一个类来计算出该非空链表的长度size
    public int size(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
    public ListNode middleNode(ListNode head) {
        int steps = size(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //输出该链表中倒数第k个结点
//    public ListNode FindKthToTail(ListNode head,int k) {
//        if (head == null) {
//            return null;
//        }

}
