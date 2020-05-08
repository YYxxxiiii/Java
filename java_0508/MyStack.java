package java_0508;

public class MyStack {
    private int[] array = new int[100];
    private int size = 0;

    //入栈
    public void push(int x) {
        array[size] = x;
        size++;
    }
    //取栈顶元素
    public int pop(int x){
        return array[size - 1];
    }
    //出栈
    public int peek(){
        int ret = array[size - 1];
        size--;
        return ret;
    }
}
