package java_0530;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    @Test
    public void t1() {
        //文件相对路径&绝对路径
        //绝对路径:全路径.  相对路径:./(当前目录), ../(上一级目录
        File file = new File("D:\\orginal\\是谁\\啥.txt");
        System.out.println(file.exists());// 文件是否存在
        File f2 = new File("是谁/啥.txt");
        System.out.println(f2.exists());
        //怎么查看当前java代码的路径(f3是在找全路径)
        File f3 = new File(".");
        System.out.println( f3.getAbsolutePath());
        System.out.println(f3.getPath());//获取路径
        System.out.println(f3.lastModified()); //上次修改时间
    }

    @Test
    public void t2() {
        File f5 = new File("D:\\orginal");
        File[] children = f5.listFiles();//返回目录下一级的子文件/子文件夹数组
        for(File child : children) {
            System.out.println(child.getName()); //文件名
        }

        
    }
}
