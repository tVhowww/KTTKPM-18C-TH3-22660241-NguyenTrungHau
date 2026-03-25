package edu.iuh.fit.library_system;

import edu.iuh.fit.library_system.decorator.*;
import edu.iuh.fit.library_system.factory.Book;
import edu.iuh.fit.library_system.observer.User;
import edu.iuh.fit.library_system.singleton.Library;
import edu.iuh.fit.library_system.strategy.SearchByName;

public class Main {
    public static void main(String[] args) {
        // Lấy instance duy nhất của Thư viện (SINGLETON)
        Library hcmLibrary = Library.getInstance();

        System.out.println("=== 1. ĐĂNG KÝ THEO DÕI (OBSERVER) ===");
        User user1 = new User("Nguyễn Trung Hậu");
        hcmLibrary.subscribe(user1);

        System.out.println("\n=== 2. NHẬP SÁCH MỚI (FACTORY) ===");
        // Khi nhập sách, hệ thống sẽ tự động gửi email cho Hậu
        hcmLibrary.addBook("PAPER", "Design Patterns", "GoF", "IT");
        hcmLibrary.addBook("PAPER", "Clean Code", "Uncle Bob", "IT");

        System.out.println("\n=== 3. TÌM KIẾM SÁCH (STRATEGY) ===");
        hcmLibrary.setSearchStrategy(new SearchByName());
        hcmLibrary.searchBook("Pattern");

        System.out.println("\n=== 4. MƯỢN SÁCH & GIA HẠN (DECORATOR) ===");
        Book bookToBorrow = hcmLibrary.getBooks().get(0);

        // Mượn cơ bản
        BorrowTicket ticket = new BasicTicket(bookToBorrow);

        // Khách muốn mua thêm gói Gia hạn
        ticket = new ExtensionDecorator(ticket);

        System.out.println("Chi tiết phiếu mượn: " + ticket.getDescription());
        System.out.println("Tổng phí: " + ticket.getFee() + " VNĐ");
    }
}