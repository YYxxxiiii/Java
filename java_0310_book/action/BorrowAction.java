package java15_0308_book.action;

import java15_0308_book.book.Book;
import java15_0308_book.book.BookList;

import java.util.Scanner;

public class BorrowAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行借书操作");
        System.out.println("请输入你要借的书籍的书名: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        // 先找到要借的书, 把书的状态改成 "借出" 即可
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                if (book.isBorrowed()) {
                    continue;
                } else {
                    book.setBorrowed(true);
                    System.out.println("借书成功!");
                    return;
                }
            }
        }
        // 可能是书名不存在, 也可能是书存在, 但是已经被借走了
        System.out.println("借书失败! 没有匹配的书籍!");
    }
}
