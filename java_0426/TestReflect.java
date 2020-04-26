package java_0426;

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(this.name + " 正在吃 " + food);
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 如何获取类对象.
        // 1) 通过字符串来获取到类, 参数是类的全限定类名.   [最重要]
        // catClass 就是 Cat 类的图纸, 里头描述了 Cat 类的内部构造
        // 通过字符串获取, 就意味着, 这个字符串可以是用户通过控制台输入的,
        // 也可以是通过读取文件获取的, 还可以是通过网络获取的.
        Class catClass = Class.forName("java15_0418.Cat");

        // 2) 通过实例来获取, 实例的 getClass 方法获取到类对象
        Cat cat = new Cat("小黑");
        Class catClass2 = cat.getClass();

        // 得到的 类对象 在内存中只有一份, 不管通过哪种方式获取到的类对象, 本质上都是同一个对象
        System.out.println(catClass == catClass2);

        // 3) 通过类来获取
        Class catClass3 = Cat.class;
        System.out.println(catClass == catClass3);
    }
}
