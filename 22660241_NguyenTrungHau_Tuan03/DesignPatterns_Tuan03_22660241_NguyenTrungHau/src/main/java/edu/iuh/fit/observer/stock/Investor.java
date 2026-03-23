package edu.iuh.fit.observer.stock;

public class Investor implements Observer {
    private String name;

    public Investor(String name) { this.name = name; }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Ting ting! [" + name + "] nhận thông báo: Cổ phiếu " + stockSymbol + " vừa cập nhật giá mới -> " + price + " VNĐ");
    }
}