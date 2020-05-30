package java_0530;

import junit.framework.Assert;
import org.junit.Test;

public class PrintWriterTest {

    //单元测试
    @Test
    public void t1() {
//        Assert.assertTrue(true);//assert断言的意思
        try {
            int i = 1 / 0;
            System.out.println("1 / 0");
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("t1");
    }
}
