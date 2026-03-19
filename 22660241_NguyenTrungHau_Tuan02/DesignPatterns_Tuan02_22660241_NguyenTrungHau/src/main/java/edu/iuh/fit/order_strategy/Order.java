package edu.iuh.fit.order_strategy;

class Order {
    private OrderHandlingStrategy strategy;

    public void setStrategy(OrderHandlingStrategy strategy) {
        this.strategy = strategy;
    }
    public void processOrder() {
        if (strategy != null) strategy.handle();
    }
}