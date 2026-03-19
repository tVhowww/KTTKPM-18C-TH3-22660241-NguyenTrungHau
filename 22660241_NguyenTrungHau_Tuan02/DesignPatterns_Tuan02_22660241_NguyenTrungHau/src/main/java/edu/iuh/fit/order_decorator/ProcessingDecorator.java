package edu.iuh.fit.order_decorator;

class ProcessingDecorator extends OrderStatusDecorator {
    public ProcessingDecorator(Order order) { super(order); }
    public String getStatus() { return wrappedOrder.getStatus() + " -> [Đang xử lý]"; }
}