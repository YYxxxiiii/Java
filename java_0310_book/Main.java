package java15_0308_book;

import java15_0308_book.book.BookList;
import java15_0308_book.user.Admin;
import java15_0308_book.user.NormalUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 先把数据准备好
        BookList bookList = new BookList();
        // 2. 创建用户, 并进行登录
        NormalUser user = login();
        // 3. 进入主循环
        while (true) {
            // 4. 循环内部调用 menu 方法显示用户菜单
            int choice = user.menu();
            // 5. 根据用户输入的选项来决定执行哪个 IAction 完成操作
            user.doAction(choice, bookList);
        }
    }

    public static NormalUser login() {
        // 提示用户进行登录
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 请登录系统!!!!");
        System.out.println(" 请输入您的姓名: ");
        String name = scanner.next();
        System.out.println(" 请输入您的身份: 1 表示管理员, 2 表示普通用户 ");
        int who = scanner.nextInt();
        return new NormalUser(name);
    }
}
