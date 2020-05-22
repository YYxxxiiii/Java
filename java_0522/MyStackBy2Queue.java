package java_0522;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    //把元素x入栈(push element x onto stack)
    public void push(int x) {
        A.offer(x);
    }

    //移除栈顶元素
    // (removes the element on top of the stack and returns that element)
    public Integer pop() {
        if(empty()) {
            return null;
        }
         while(A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
         }
         int ret = A.poll();
        swapAB();
        return ret;
    }

    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    //获取栈顶元素
    //(Get the top element)
    public Integer top() {
        if(empty()) {
            return null;
        }
        while(A.size() > 1) {
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}

