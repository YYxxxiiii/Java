package java_0421;

public class Heap {
    public static void shiftDown(int[] array,int size,int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child <size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] < array[parent]) {
                //不符合小堆规则,就交换父子节点
                int tmp = array[parent];
                array[parent] = tmp;
            } else {
                //调整完毕,就不需要继续了
                break;
            }
            //更新 parent 和child,处理下一层的数据
            parent = child;
            child = parent * 2 + 1;
        }
    }
}
