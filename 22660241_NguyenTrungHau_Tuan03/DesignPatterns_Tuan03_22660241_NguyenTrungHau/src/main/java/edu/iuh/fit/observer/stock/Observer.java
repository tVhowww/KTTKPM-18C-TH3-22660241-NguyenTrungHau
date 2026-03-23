package edu.iuh.fit.observer.stock;

public interface Observer {
    void update(String stockSymbol, double price);
}