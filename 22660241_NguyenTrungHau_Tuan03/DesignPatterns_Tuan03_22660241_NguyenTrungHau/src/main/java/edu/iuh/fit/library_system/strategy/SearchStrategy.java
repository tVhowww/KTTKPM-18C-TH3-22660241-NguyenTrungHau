package edu.iuh.fit.library_system.strategy;
import edu.iuh.fit.library_system.factory.Book;
import java.util.List;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}