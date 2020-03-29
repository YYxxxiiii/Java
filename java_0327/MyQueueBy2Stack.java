package java15_0327;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

public class MyQueueBy2Stack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public void push(int x) {
        // 1. 先把 B 中的元素都倒腾到 A 里
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        // 2. 把新元素入 A 即可
        A.push(x);
    }

    public Integer pop() {
        // 1. 如果为空, 就直接返回
        if (empty()) {
            return null;
        }
        // 2. 把 A 中的元素都倒腾给 B
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 3. 针对 B 进行出栈
        return B.pop();
    }

    public Integer peek() {
        // 1. 如果为空, 就直接返回
        if (empty()) {
            return null;
        }
        // 2. 把 A 中的元素都倒腾给 B
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 3. 直接取 B 的栈顶元素
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
