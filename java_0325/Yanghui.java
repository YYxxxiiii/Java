package java15_0325;

import java.util.ArrayList;
import java.util.List;

public class Yanghui {
    public List<List<Integer>> generate(int numRows) {
        // 杨辉三角的特点:
        // 1. 第一行固定, 就是一个 1
        // 2. 第二行也固定, 就是两个 1
        // 3. 第 i 行, 收尾元素都固定是 1
        // 4. 第 i 行有 i 个元素
        // 5. 对于第 i 行来说, 第 j 列的值是 i - 1 行 j - 1 列值 加上 i - 1 行 j 列值
        //    例如, 第 2 行第 2 列 值是 2. 就是 第 1 行第 1 列 + 第 1 行第 2 列
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 1. 先准备第一行, 就只有 1 个元素
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        // 2. 再插入第二行. 就只有 2 个元素
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        // 3. 就要处理第 i 行的情况了
        //  a) 第 i 行有 i 列
        //  b) (i, j) = (i - 1, j) + (i - 1, j - 1);
        //  c) 第一个元素和最后一个元素都固定是 1
        //  arr[row][col];
        //  result.get(row).get(col);
        //  List<Integer> line = result.get(row);
        //  line.get(col);
        for (int row = 3; row <= numRows; row++) {
            // 如果要想知道第 row 行的情况, 就得先知道 row - 1 行的内容
            List<Integer> prevLine = result.get((row - 1) - 1);  // 难点1
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            // 第 row 行应该有 row 列, 下面这个循环相当于循环了 row - 2 次
            // 因为第一列和最后一列都固定是1, 不参与循环
            // 针对这种 "差一" 问题, 最好的办法就是套入具体的数字来验证下是否合理.
            // 如果 row 为 5 的话, 第 5 行应该有 5 列. 下面的循环应该就要执行 3 次
            for (int col = 2; col < row; col++) { // 难点2 (循环到底要执行几次)
                // 此处 col 也是从 1 开始计算的. 转换成下标需要继续再 - 1
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1); // 难点3(col - 1 - 1)
                curLine.add(curNum);
            }
            // 最后处理该行的最后一个 1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
