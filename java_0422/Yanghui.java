package java_0422;

import java.util.ArrayList;
import java.util.List;

public class Yanghui {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //1.插入第一行,只有1一个元素
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        //2.插入第二行,就只有2个元素
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        //3.处理第i行的情况
        for (int row = 3; row <= numRows; row++) {
            List<Integer> prevLine = result.get((row - 1) - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);

            //第row行应该有row列,下面的循环相当于循环了row - 2次
            //第一列和最后一列都是1,所以不参与循环
            for (int col = 2;col < row; col++) {
                //此处的col是从1 开始计算的,转换成下标需要再－1
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            //最后处理该行的最后一个1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }

}
