package edu.iuh.fit.library_system.singleton;

import edu.iuh.fit.library_system.factory.Book;
import edu.iuh.fit.library_system.factory.BookFactory;
import edu.iuh.fit.library_system.observer.Observer;
import edu.iuh.fit.library_system.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // 1. SINGLETON: Chỉ có 1 instance thư viện
    private static Library instance;
    private List<Book> books;
    private List<Observer> subscribers;
    private SearchStrategy searchStrategy;

    private Library() {
        books = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public static synchronized Library getInstance() {
        if (instance == null) instance = new Library();
        return instance;
    }

    // 2. OBSERVER: Quản lý người theo dõi
    public void subscribe(Observer o) { subscribers.add(o); }
    private void notifyObservers(String message) {
        for (Observer o : subscribers) o.update(message);
    }

    // 3. FACTORY: Thêm sách mới
    public void addBook(String type, String title, String author, String category) {
        Book newBook = BookFactory.createBook(type, title, author, category);
        books.add(newBook);
        System.out.println("-> Thư viện vừa nhập kho: " + title);
        notifyObservers("Sách mới cực hot: '" + title + "' của " + author + " đã có mặt tại thư viện!");
    }

    // 4. STRATEGY: Đổi thuật toán tìm kiếm
    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public void searchBook(String keyword) {
        if (searchStrategy == null) {
            System.out.println("Vui lòng chọn phương thức tìm kiếm!");
            return;
        }
        System.out.println("--- Kết quả tìm kiếm cho: '" + keyword + "' ---");
        List<Book> results = searchStrategy.search(books, keyword);
        if (results.isEmpty()) System.out.println("Không tìm thấy sách phù hợp.");
        else results.forEach(Book::display);
    }

    public List<Book> getBooks() { return books; }
}