public class QueueByA {
    private int[] array = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0; 
    public void offer(int val) {
        if (size == array.length) {
            return;
        }
        array[tail] = val;
        tail++;
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
