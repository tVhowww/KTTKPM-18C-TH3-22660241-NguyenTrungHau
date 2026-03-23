package edu.iuh.fit.observer.stock;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private String symbol;
    private double price;
    private List<Observer> investors; // Danh sách người đăng ký

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.investors = new ArrayList<>();
    }

    public void setPrice(double price) {
        if (this.price != price) {
            this.price = price;
            // Kích hoạt thông báo tự động mỗi khi giá đổi
            notifyObservers();
        }
    }

    @Override
    public void attach(Observer o) { investors.add(o); }

    @Override
    public void detach(Observer o) { investors.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer investor : investors) {
            investor.update(symbol, price);
        }
    }
}