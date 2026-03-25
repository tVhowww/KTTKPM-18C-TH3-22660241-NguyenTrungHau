package edu.iuh.fit.library_system.decorator;
import edu.iuh.fit.library_system.factory.Book;

public class BasicTicket implements BorrowTicket {
    private Book book;
    public BasicTicket(Book book) { this.book = book; }

    @Override public String getDescription() { return "Mượn sách '" + book.getTitle() + "' (Tiêu chuẩn)"; }
    @Override public double getFee() { return 5000; } // Phí mượn cơ bản
}