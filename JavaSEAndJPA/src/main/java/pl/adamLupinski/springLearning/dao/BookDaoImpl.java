package pl.adamLupinski.springLearning.dao;

import pl.adamLupinski.springLearning.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {

   private EntityManagerFactory entityManagerFactory;
   private EntityManager entityManager;

    public BookDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();

    }

    public void save(Book book) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
    }

    public Book get(Long id) {
        return entityManager.find(Book.class,id);
    }

    public void cleanUp() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
