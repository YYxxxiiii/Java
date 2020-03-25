package java15_0325;

public class MyQueueByArray {
    private int[] array = new int[100];
    // [head, tail) 有效元素的范围. 注意, tail 可能在 head 之前
    private int head = 0;
    private int tail = 0;
    private int size = 0;  // 元素个数

    public void offer(int val) {
        if (size == array.length) {
            // 队列满了, 无法继续插入
            return;
        }
        // 得保证这个操作下标不能越界
        array[tail] = val;
        tail++;
        // tail++ 之后如果超出了数组的有效范围, 就从头开始
        if (tail >= array.length) {
            tail = 0;
        }
        size++;
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = array[head];
        head++;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }
}
