package java15_0325;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int ret = stack.pop();
        System.out.println(ret);    // 4
        ret = stack.pop();
        System.out.println(ret);    // 3
        ret = stack.pop();
        System.out.println(ret);    // 2
        ret = stack.pop();
        System.out.println(ret);    // 1
        ret = stack.pop();
        System.out.println(ret);    // ???
    }
}
