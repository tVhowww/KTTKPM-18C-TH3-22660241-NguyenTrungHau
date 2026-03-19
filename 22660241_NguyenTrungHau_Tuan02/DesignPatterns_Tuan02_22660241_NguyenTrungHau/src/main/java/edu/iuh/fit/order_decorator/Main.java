package edu.iuh.fit.order_decorator;

public class Main {
    public static void main(String[] args) {
        Order order = new BaseOrder();
        System.out.println(order.getStatus());

        // Cố tình bọc để chuyển trạng thái
        order = new ProcessingDecorator(order);
        System.out.println(order.getStatus());

        order = new DeliveredDecorator(order);
        System.out.println(order.getStatus());
    }
}
