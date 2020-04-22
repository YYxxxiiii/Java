package java_0422;

import java.util.ArrayList;
import java.util.List;

public class YanghuiText {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }

        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }

        for (int row = 3; row <= numRows; row++) {
            List<Integer> prevLine = result.get(row - 1 - 1);  //******
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);

            for (int col = 2;col < row;col++) {
                int curNum = prevLine.get(col - 1 - 1) + prevLine.get(col - 1);
                curLine.add(curNum);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
