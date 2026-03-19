package edu.iuh.fit.payment_system.decorator;
import edu.iuh.fit.payment_system.strategy.PaymentStrategy;

public class ProcessingFeeDecorator extends PaymentDecorator {
    public ProcessingFeeDecorator(PaymentStrategy payment) {
        super(payment);
    }

    @Override
    public void pay(double amount) {
        double fee = amount * 0.02; // Phí xử lý giao dịch là 2%
        System.out.println("-> Cảnh báo: Áp dụng 2% phí xử lý giao dịch (" + fee + " VNĐ).");

        // Cộng phí vào tổng tiền rồi mới đẩy cho lớp bên trong thanh toán
        super.pay(amount + fee);
    }
}