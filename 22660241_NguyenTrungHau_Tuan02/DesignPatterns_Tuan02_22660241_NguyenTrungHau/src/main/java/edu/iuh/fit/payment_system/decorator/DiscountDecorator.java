package edu.iuh.fit.payment_system.decorator;
import edu.iuh.fit.payment_system.strategy.PaymentStrategy;

public class DiscountDecorator extends PaymentDecorator {
    private double discountAmount;

    public DiscountDecorator(PaymentStrategy payment, double discountAmount) {
        super(payment);
        this.discountAmount = discountAmount;
    }

    @Override
    public void pay(double amount) {
        System.out.println("-> Khuyến mãi: Áp dụng mã giảm giá trực tiếp -" + discountAmount + " VNĐ.");
        double finalAmount = amount - discountAmount;
        if (finalAmount < 0) finalAmount = 0;

        // Trừ đi khuyến mãi rồi mới đẩy cho lớp bên trong thanh toán
        super.pay(finalAmount);
    }
}