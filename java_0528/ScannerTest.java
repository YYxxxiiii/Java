package java_0528;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * 假设,接收的输入为:
         * 4
         * 3 1 10 31
         */
        //hasNextXXX()和nextXXX()读取到io数据直到满足条件(空格和换行符), 否则阻塞等待
        //io流无论读写只能操作一次(不包括while里的hasNextXXX(),不操作,只判断),
        //和nextXXX()读取一下,io流跑到下一个读取位置
        while (sc.hasNextInt()) { //这一行,之后最好都加上他
            int num = sc.nextInt(); // 读取到io数据直到满足条件, 否则阻塞等待
            for (int i = 0; i < num; i++) { //此处的hadNextInt()是和下面那个nextInt对应的
                int data = sc.nextInt();
                System.out.println(data);
            }
        }
    }
}
