package edu.iuh.fit.payment_system;

import edu.iuh.fit.payment_system.decorator.DiscountDecorator;
import edu.iuh.fit.payment_system.decorator.ProcessingFeeDecorator;
import edu.iuh.fit.payment_system.strategy.CreditCardPayment;
import edu.iuh.fit.payment_system.strategy.PayPalPayment;
import edu.iuh.fit.payment_system.strategy.PaymentStrategy;

public class Main {
    public static void main(String[] args) {
        double baseAmount = 1000000; // Tiền gốc: 1 triệu VNĐ

        System.out.println("=== KỊCH BẢN 1: Thanh toán PayPal bình thường ===");
        PaymentStrategy payment1 = new PayPalPayment();
        payment1.pay(baseAmount);

        System.out.println("\n=== KỊCH BẢN 2: Thẻ tín dụng + Phí xử lý (2%) ===");
        // Dùng Strategy là Thẻ tín dụng
        PaymentStrategy payment2 = new CreditCardPayment();
        // Bọc Decorator Phí xử lý ra ngoài Thẻ tín dụng
        payment2 = new ProcessingFeeDecorator(payment2);
        payment2.pay(baseAmount);

        System.out.println("\n=== KỊCH BẢN 3: PayPal + Giảm giá 50k + Phí xử lý (2%) ===");
        PaymentStrategy payment3 = new PayPalPayment();
        // Bọc lớp giảm giá
        payment3 = new DiscountDecorator(payment3, 50000);
        // Tiếp tục bọc lớp phí xử lý ra ngoài cùng (Phí sẽ tính trên giá gốc)
        payment3 = new ProcessingFeeDecorator(payment3);

        // Khi gọi pay(), nó sẽ chạy từ ngoài vào trong: Tính phí -> Trừ giảm giá -> Thanh toán PayPal
        payment3.pay(baseAmount);
    }
}

// KẾT LUẬN:
//    Trong hệ thống thanh toán, Strategy Pattern được sử dụng để định
//    nghĩa các phương thức thanh toán lõi (Thẻ tín dụng, PayPal), giúp
//    client dễ dàng chuyển đổi phương thức thanh toán mà không làm thay
//    đổi hệ thống. Sự kết hợp với Decorator Pattern thể hiện sức mạnh to
//    lớn khi nó cho phép bọc các tính năng phụ trợ (Tính phí xử lý, Trừ
//    mã giảm giá) lên trên phương thức thanh toán gốc. Các Decorator này
//    can thiệp vào tham số số tiền (amount) trước khi đẩy xuống cho
//    Strategy gốc xử lý. Cách thiết kế này giúp hệ thống tránh được sự
//    bùng nổ tổ hợp các class (ví dụ không cần tạo class CreditCardWithFeeAndDiscount).