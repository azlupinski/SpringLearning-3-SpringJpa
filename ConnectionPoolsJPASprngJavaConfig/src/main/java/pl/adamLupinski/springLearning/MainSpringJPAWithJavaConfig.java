package pl.adamLupinski.springLearning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.adamLupinski.springLearning.dao.BookDao;
import pl.adamLupinski.springLearning.model.Book;

@Configuration
@ComponentScan
public class MainSpringJPAWithJavaConfig {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainSpringJPAWithJavaConfig.class);

        BookDao bookDao = context.getBean(BookDao.class);

        Book book = new Book("1234567890123", "Komunikacja werbalna", "Jean Claude VanDame");

        bookDao.save(book);
        System.out.println("Book has been saved");

        Book foundbook  = bookDao.get(1L);
        System.out.println(foundbook);
        Thread.sleep(5000);
        context.close();

    }
}
