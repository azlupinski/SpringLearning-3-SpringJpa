package pl.adamLupinski.springLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adamLupinski.springLearning.dao.BookDao;
import pl.adamLupinski.springLearning.model.Book;

@SpringBootApplication
public class JpaInSpringBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(JpaInSpringBootApplication.class, args);
        BookDao bookDao = context.getBean(BookDao.class);

        Book book = new Book("0987654321234", "Augustowianka", "Niegazowana");
        bookDao.save(book);
        Thread.sleep(5000);
        bookDao.get(1L);

    }

}
