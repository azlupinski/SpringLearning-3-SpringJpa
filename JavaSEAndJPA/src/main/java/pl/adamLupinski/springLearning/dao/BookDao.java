package pl.adamLupinski.springLearning.dao;

import pl.adamLupinski.springLearning.model.Book;

public interface BookDao {

    void save(Book book);
    Book get(Long id);
    void cleanUp();
}
