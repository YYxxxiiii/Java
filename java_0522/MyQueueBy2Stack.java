package java_0522;

import java.util.Stack;

public class MyQueueBy2Stack {
    //A用来入队列
    //B用来出队列
    //右边为栈顶
    //也就是说A的最左端为队首
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    // 将一个元素放入队列的尾部
    public void push(int x) {
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    //从队列首部移除元素
    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();
    }


    //返回队列首部的元素
    public Integer peek() {
        if (empty()) {
            return null;
        }
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
