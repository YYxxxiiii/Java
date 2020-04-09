import java.util.Arrays;

public class TestSort {
    // 升序排序
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;  // 已排序区间的最后一个元素下标
            for (; cur >= 0; cur--) {
                if (array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap;  // 这个操作是在找同组中的上一个元素
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    // 打擂成功
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void heapSort(int[] array) {
        // 先建立堆, 面试的时候, 也建议大家单独写一个建堆方法.
        createHeap(array);
        // 循环把堆顶元素交换到最后. 并进行调整堆
        // 循环此时是 length - 1. 当堆中只剩一个元素的时候, 也就一定是有序的了.
        for (int i = 0; i < array.length - 1; i++) {
            // 当前堆的元素个数
            int heapSize = array.length - i;
            // 交换 堆顶元素 和 堆的最后一个元素
            // 堆的元素个数相当于 array.length - i
            // 堆的最后一个元素下标 array.length - i - 1
            // 取堆的最后一个元素
            swap(array, 0, heapSize - 1);
            heapSize--; // 就把最后一个元素从堆中排除掉. 堆的 size 就 --

            // 交换完成之后, 要把最后一个元素从堆中删掉
            // 堆的长度就又进一步缩水了 array.length - i - 1
            // 数组中
            // [0, array.length - i - 1) 待排序区间
            // [array.length - i - 1, array.length) 已排序区间
            // [注意!!!!] 这个代码中的边界条件特别容易搞错~~ -1 还是 不减 还是 + 1, 最好代入数值来验证.
            // 例如可以验证下 i = 0 的时候, 咱们的逻辑是否合理.
            shiftDown(array, heapSize, 0);
        }
    }

    private static void createHeap(int[] array) {
        // 从最后一个非叶子节点出发向前循环, 依次进行向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        // 这里咱们是升序排序, 建立的是大堆. 大堆就需要找出左右子树中的较大值, 再和根节点比较
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 条件结束意味着, child 就已经是左右子树比较大的值的下标了
            if (array[child] > array[parent]) {
                // 需要交换两个元素
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void bubbleSort(int[] array) {
        // 按照每次找最小的方式来进行排序. (从后往前比较交换)
        for (int bound = 0; bound < array.length; bound++) {
            // [0, bound) 已排序区间
            // [bound, size) 待排序区间
            // cur > bound 而不是 >= , 当 bound 为 0 的时候, 如果 >= , cur 也为 0, cur - 1 也就下标越界了
            for (int cur = array.length - 1; cur > bound; cur--) {
                // 此处 cur - 1 是因为 cur 初始值是 array.length - 1. 如果取 cur + 1 下标的元素, 就越界了
                // 此处的条件如果写成 >= 同样无法保证稳定性
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        // insertSort(arr);
        // shellSort(arr);
        // selectSort(arr);
        // heapSort(arr);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
