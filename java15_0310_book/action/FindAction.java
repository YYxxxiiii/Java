package java15_0308_book.action;

import java15_0308_book.book.Book;
import java15_0308_book.book.BookList;

import java.sql.SQLOutput;
import java.util.Scanner;

public class FindAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行查找图书操作");
        // 根据名字来找到对应的书籍信息
        System.out.println("请输入要查找的书籍名字: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                System.out.println(book);
            }
        }
    }
}
