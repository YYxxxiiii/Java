package java_0420

import java.util.Arrays;

public class TestEnum {
    // 需要在代码中表示性别.
    // 可以约定, 1 表示男性, 2 表示女性, 3 表示其他.
//    public static final int MALE = 1;
//    public static final int FEMALE = 2;
//    public static final int OTHER = 3;

    public static void main(String[] args) {

        // 通过刚才定义常量来表示性别, 代码可读性是提高了, 但是对于下面的场景
        // 编译器并没有明确的约束. 按理説这个代码是无意义的, 但是编译仍然能正常编译.
        // System.out.println(Arrays.toString(Sex.values()));
        Sex sex = Sex.valueOf("MALE");
        if (sex == Sex.MALE) {
            System.out.println("得到一个 MALE 类型的枚举常量");
        }
    }
}
