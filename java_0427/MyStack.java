package java_0427;

public class MyStack {
    private int[] arrays = new int[100];
    private int size = 0;

    //入栈
    public void push(int x) {
        arrays[size] = x;
        size++;
    }

    //取栈顶元素(最后进的那个元素)
    public int peek() {
        return arrays[size - 1];
    }

    //出栈
    public int pop() {
        int ret = arrays[size - 1];
        size--;
        return ret;
    }
}
