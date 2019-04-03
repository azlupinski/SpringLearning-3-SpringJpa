package pl.adamLupinski.springLearning.main;

import pl.adamLupinski.springLearning.dao.BookDao;
import pl.adamLupinski.springLearning.dao.BookDaoImpl;
import pl.adamLupinski.springLearning.model.Book;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("1234567890123", "Komunikacja niewerbalna", "Jean Claude-Martin");
        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);
        System.out.println("Book has been saved");
        System.out.println(bookDao.get(1L));

        bookDao.cleanUp();

    }
}
