package java_0508;

import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //1.插入第一行
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if  (numRows == 1) {
            return result;
        }
        //2.插入第二行,只有两个元素
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        //3.处理第 i 行的情况
        // a)第 i 行有 i 列
        // b)(i, j) = (i - 1, j) + (i - 1, j - 1);
        // c)第一个元素和最后一个元素都固定为 1
        for (int row = 3; row <= numRows; row++) {
            //如果想知道第 row 行的情况,就得先知道 row - 1 行
            List<Integer> prevLine = result.get((row - 1) -1);
            //第一次减一是为了得到 row - 1 行
            //第二次是为了得到 row - 1 行的下标
            //下标是从 0 开始的
            List<Integer> curLine = new ArrayList<>();//当前行
            curLine.add(1);
            //第 row 行应为row列, 下面这个循环相当于循环了 row - 2 次
            //因为第一列和最后一列都是 固定的 1 ,不参与循环
            //针对 差一 问题, 最好的办法就是套入具体数字来验证是否合理
            //如果row 为 5 ,第5 行应该有第五列 , 下面的循环应执行3次
            for (int col = 2; col < row; col++) {
                //col 是从 1 开始计数的, 需要转换成下标 ,所以 - 1
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            //处理该行最后一个 1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
