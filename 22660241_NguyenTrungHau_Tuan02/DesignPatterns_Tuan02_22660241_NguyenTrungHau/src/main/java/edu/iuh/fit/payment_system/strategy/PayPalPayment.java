package edu.iuh.fit.payment_system.strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Đã thanh toán thành công " + amount + " VNĐ qua cổng PayPal.");
    }
}