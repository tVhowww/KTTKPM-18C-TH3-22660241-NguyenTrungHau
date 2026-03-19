package edu.iuh.fit.order_decorator;

class DeliveredDecorator extends OrderStatusDecorator {
    public DeliveredDecorator(Order order) { super(order); }
    public String getStatus() { return wrappedOrder.getStatus() + " -> [Đã giao]"; }
}
