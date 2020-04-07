package java_0407;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int n1;
    public int n2;
    public int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = n1 + n2;
    }

    @Override
    public int compareTo(Pair o) {
        // this 比 other 小, 返回 < 0
        // this 比 other 大, 返回 > 0
        // this 和 other 相等, 返回 0
        // 此处直接用 sum 值来衡量 Pair 的大小
        return this.sum - o.sum;
    }
}

public class HeapExam {
    // [
    //    [1, 1],
    //    [1, 2]
    // ]
    // 返回值的二维数组中, 每一行是一个数对(每一行只有两个元素).
    // 一共应该有 k 行.
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        // 当前是需要前 k 小的元素, 就建立一个小堆
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        // 采取第一种方式来做
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));
            }
        }
        // 循环结束之后, 此时所有数对都在队列中, 循环取出 k 个较小元素即可
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            Pair cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.n1);
            tmp.add(cur.n2);
            result.add(tmp);
        }

        return result;
    }
}
