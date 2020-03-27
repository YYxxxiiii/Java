package java15_0327;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    public void push(int x) {
        // x 往 A 中入队列即可
        A.offer(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        // 把 A 中的元素往 B 中倒腾
        while (A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
        }
        // 当循环结束之后, A 中应该就是 1 个元素;
        // 这个元素就应该是被出栈的元素
        int ret = A.poll();
        // 交换 A 和 B 的身份
        swapAB();
        return ret;
    }

    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;

//        A = B;
//        B.clear();
    }

    public Integer top() {
        if (empty()) {
            return null;
        }
        // 把 A 中的元素往 B 中倒腾
        while (A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
        }
        // 当循环结束之后, A 中应该就是 1 个元素;
        // 这个元素就应该是被出栈的元素
        int ret = A.poll();
        B.offer(ret);   // top 和 pop 唯一的区别就是这句话
        // 交换 A 和 B 的身份
        swapAB();
        return ret;
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
