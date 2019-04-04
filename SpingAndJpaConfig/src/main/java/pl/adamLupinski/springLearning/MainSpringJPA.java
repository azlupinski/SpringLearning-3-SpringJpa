package pl.adamLupinski.springLearning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.adamLupinski.springLearning.dao.BookDao;
import pl.adamLupinski.springLearning.model.Book;

@Configuration
@ComponentScan
public class MainSpringJPA {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainSpringJPA.class);

        BookDao bookDao = context.getBean(BookDao.class);

        Book book = new Book("1234567890123", "Komunikacja werbalna", "Jean Claude VanDame");

        bookDao.save(book);
        System.out.println("Book has been saved");

        Book foundbook  = bookDao.get(1L);
        System.out.println(foundbook);
        context.close();

    }
}
