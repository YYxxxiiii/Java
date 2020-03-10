package java15_0308_book.user;

import java15_0308_book.action.*;
import java15_0308_book.book.BookList;

import java.util.Scanner;

public class NormalUser {
    private String name;
    private IAction[] actions = new IAction[] {
            new ExitAction(),
            new FindAction(),
            new BorrowAction(),
            new ReturnAction(),
    };

    public NormalUser(String name) {
        this.name = name;
    }

    public int menu() {
        System.out.println("================");
        System.out.println(" 欢迎 " + this.name + " 使用图书馆管理系统");
        System.out.println(" 1. 查找书籍");
        System.out.println(" 2. 借书");
        System.out.println(" 3. 还书");
        System.out.println(" 0. 退出");
        System.out.println("================");
        System.out.println(" 请输入您的选项: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public void doAction(int choice, BookList bookList) {
        actions[choice].work(bookList);
    }
}
