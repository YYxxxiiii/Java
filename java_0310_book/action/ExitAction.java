package java15_0308_book.action;

import java15_0308_book.book.BookList;

public class ExitAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("goodbye!!!");
        System.exit(0);
    }
}
