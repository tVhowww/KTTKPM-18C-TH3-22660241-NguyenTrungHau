package edu.iuh.fit.payment_system.strategy;

// Interface đóng vai trò là Strategy gốc, đồng thời là Component cho Decorator
public interface PaymentStrategy {
    void pay(double amount);
}