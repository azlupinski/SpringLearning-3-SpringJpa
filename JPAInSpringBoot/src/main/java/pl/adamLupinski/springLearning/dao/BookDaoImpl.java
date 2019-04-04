package pl.adamLupinski.springLearning.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.adamLupinski.springLearning.model.Book;

import javax.persistence.*;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoImpl() {
    }

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book get(Long id) {
        Book book = entityManager.find(Book.class,id);
        return book;
    }
}
