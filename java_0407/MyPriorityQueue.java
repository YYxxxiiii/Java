package java_0407;

public class MyPriorityQueue {
    // array 看起来是一个数组, 其实应该是一个堆的结构
    private int[] array = new int[100];
    private int size = 0;

    public void offer(int x) {
        array[size] = x;
        size++;
        // 把新加入的元素进行向上调整
        shiftUp(array, size - 1);
    }

    // 此时发现 size 这个参数没用上. 仔细想想, 好像也确实不需要.
    // 判定调整完了, 只需要和 0 比较即可. 不需要知道整个堆有多大.
    private static void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[parent] < array[child]) {
                // 当前不符合大堆要求.
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            } else {
                // 发现当前 父节点 比子节点大. 这个时候说明整个数组已经符合堆的结构了
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public int poll() {
        // 下标为 0 的元素就是队首元素. 删掉的同时, 我们也希望剩下的结构仍然是一个堆
        int oldValue = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return oldValue;
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        // 这个条件的含义是看看 parent 有没有子节点
        while (child < size) {
            // 把左右子树中较大的节点找到
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 上述条件结束后, child 肯定对应左右子树中比较大的元素.
            // 再拿当前的这个 child 和 parent 位置的元素比较一下
            if (array[child] > array[parent]) {
                // 交换父子节点的位置
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                // 当前这个位置开始, 已经符合堆的要求了, 不需要继续调整
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public int peek() {
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
        }
    }
}
