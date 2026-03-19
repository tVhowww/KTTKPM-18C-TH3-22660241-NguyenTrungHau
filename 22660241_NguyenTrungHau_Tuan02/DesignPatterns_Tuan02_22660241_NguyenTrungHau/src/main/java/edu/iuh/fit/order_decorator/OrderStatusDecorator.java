package edu.iuh.fit.order_decorator;

abstract class OrderStatusDecorator implements Order {
    protected Order wrappedOrder;
    public OrderStatusDecorator(Order order) { this.wrappedOrder = order; }
}