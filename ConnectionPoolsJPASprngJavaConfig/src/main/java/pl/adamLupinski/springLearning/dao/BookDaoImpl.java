package pl.adamLupinski.springLearning.dao;

import org.springframework.stereotype.Repository;
import pl.adamLupinski.springLearning.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


    public BookDaoImpl() {
    }

    public void save(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        entityManager.close();
    }

    public Book get(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = entityManager.find(Book.class,id);
        entityManager.close();
        return book;
    }


}
