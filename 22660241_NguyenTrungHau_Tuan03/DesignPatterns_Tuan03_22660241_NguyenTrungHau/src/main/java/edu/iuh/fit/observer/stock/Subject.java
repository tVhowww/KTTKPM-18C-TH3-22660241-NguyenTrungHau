package edu.iuh.fit.observer.stock;

public interface Subject {
    void attach(Observer o); // Đăng ký theo dõi
    void detach(Observer o); // Hủy theo dõi
    void notifyObservers();  // Gửi thông báo
}