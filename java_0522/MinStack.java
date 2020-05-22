package java_0522;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    //将元素 x 推入栈中。
    public void push(int x) {
        A.push(x);
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        B.push(min);
    }

    // 删除栈顶的元素。
    public Integer pop() {
        if (A.isEmpty()) {
            return null;
        }
        B.pop();
        return A.pop();
    }

    //获取栈顶元素。
    public Integer top() {
        if (A.isEmpty()) {
            return null;
        }
        return A.peek();
    }

    //检索栈中的最小元素。
    public Integer getMin() {
        if (A.isEmpty()) {
            return null;
        }
        return B.peek();
    }

}
