package edu.iuh.fit.order_strategy;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        // Client phải TỰ BIẾT quá trình chuyển đổi và tự set bằng tay
        order.setStrategy(new NewOrderStrategy());
        order.processOrder();

        order.setStrategy(new ProcessingOrderStrategy());
        order.processOrder();
    }
}
