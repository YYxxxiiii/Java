package java_0407;

import java.util.Arrays;

// 此处咱们按大堆来实现, 大堆要求父节点比子节点大.
public class Heap {
    // size: array 中哪部分内容是堆
    // index: 从哪个位置开始进行向下调整
    public static void shiftDown(int[] array, int size, int index) {
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

    public static void createHeap(int[] array, int size) {
        // 基于向下调整来建堆.
        // 建堆可以基于向下调整, 也可以基于向上调整
        // 如果是向下调整, 就需要从后往前遍历数组
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        createHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
