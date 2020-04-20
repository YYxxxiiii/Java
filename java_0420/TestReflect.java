package java_0420

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Animal {
    public void eat(String food) {

    }
}

class Cat extends Animal {
    private String name;

    public Cat() {
        this.name = "小猫";
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void eat(String food) {
        System.out.println(this.name + " 正在吃 " + food);
    }
}

class Bird extends Animal {
    private String name;

    public Bird() {
        name = "小鸟";
    }

    @Override
    public void eat(String food) {
        System.out.println(this.name + " 正在吃 " + food);
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 1. 如何获取类对象.
        // 1) 通过字符串来获取到类, 参数是类的全限定类名.   [最重要]
        // catClass 就是 Cat 类的图纸, 里头描述了 Cat 类的内部构造
        // 通过字符串获取, 就意味着, 这个字符串可以是用户通过控制台输入的,
        // 也可以是通过读取文件获取的, 还可以是通过网络获取的.
        // Class catClass = Class.forName("java15_0418.Cat");

        // 2) 通过实例来获取, 实例的 getClass 方法获取到类对象
//        Cat cat = new Cat("小黑");
//        Class catClass2 = cat.getClass();

        // 得到的 类对象 在内存中只有一份, 不管通过哪种方式获取到的类对象, 本质上都是同一个对象
//        System.out.println(catClass == catClass2);
//
//        // 3) 通过类来获取
//        Class catClass3 = Cat.class;
//        System.out.println(catClass == catClass3);

        // 2. 通过类对象来创建实例
        //    平时创建实例都是通过 new 的方式.
        //    catClass 表示 Cat 类的类对象. 也就是 Cat 类的图纸.
        //    newInstance 创建对应的实例
        //    以下代码运行是出现了异常. Cat 类没有提供无参数的构造方法.
        //    直接实例化就会出现问题.
//        Scanner scanner = new Scanner(System.in);
//        String className = scanner.next();
//        System.out.println("您要创建的实例类型为: " + className);
//
//        Class animalCat = Class.forName(className);
//        Animal animal = (Animal) animalCat.newInstance();
//        animal.eat("鱼");

        // 3. 通过反射获取/修改属性(可以修改 private 的属性)
//        Class catClass = Class.forName("java15_0418.Cat");
//        // Cat 类中包含 name 属性, private 的属性.
//        // catClass 类对象是整个类的图纸. 此处想关注一个图纸上的局部信息(name)
//        // 通过 getDeclaredField 能得到局部内容. 通过 Field 对象来表示
//        Field field = catClass.getDeclaredField("name");
//        // 这个代码加上之后, 才能访问 private 的成员
//        field.setAccessible(true);
//
//        Cat cat = new Cat();
//        // 拿着图纸中的局部信息, 拆开 cat 对象, 看看里面到底是啥.
//        // 除了获取属性之外, 还可以根据名字来修改属性
//        field.set(cat, "小萌喵");  // 这个代码相当于 cat.name = "小萌喵"
//        String name = (String) field.get(cat);  // 这个代码相当于 cat.name
//        System.out.println(name);

        // 4. 通过反射获取到类中的方法.
//        Class catClass = Class.forName("java15_0418.Cat");
//        // 根据 catClass 这个图纸, 找到 Cat 类中的 eat 方法.
//        // 方法是可以重载的. 就可以通过后续的变长参数列表来指定, 要获取哪个版本的 eat.
//        // 下面这个代码的意思是获取到 只有一个 参数 且类型为 String 的 eat 方法
//        Method method = catClass.getMethod("eat", String.class, String.class);
//        Cat cat = new Cat();
//        method.invoke(cat, "猫粮");

        // 5. 获取构造方法, 借助构造方法来实例化对象
//        Class catClass = Class.forName("java15_0418.Cat");
//        // 获取到 Cat 类中, 只有一个参数且类型为 String 的构造方法
//        Constructor constructor = catClass.getConstructor(String.class, String.class);
//        Cat cat = (Cat) constructor.newInstance("小黑");
//        cat.eat("鱼");
    }
}
