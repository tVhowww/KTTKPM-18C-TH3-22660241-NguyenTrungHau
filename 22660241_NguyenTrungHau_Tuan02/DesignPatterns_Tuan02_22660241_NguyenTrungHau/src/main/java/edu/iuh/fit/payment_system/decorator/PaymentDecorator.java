package edu.iuh.fit.payment_system.decorator;
import edu.iuh.fit.payment_system.strategy.PaymentStrategy;

public abstract class PaymentDecorator implements PaymentStrategy {
    protected PaymentStrategy wrappedPayment; // Đối tượng bị bọc

    public PaymentDecorator(PaymentStrategy payment) {
        this.wrappedPayment = payment;
    }

    @Override
    public void pay(double amount) {
        wrappedPayment.pay(amount); // Ủy quyền cho đối tượng bên trong
    }
}