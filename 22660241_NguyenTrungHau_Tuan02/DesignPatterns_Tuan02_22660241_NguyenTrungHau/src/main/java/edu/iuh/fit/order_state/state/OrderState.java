package edu.iuh.fit.order_state.state;
import edu.iuh.fit.order_state.Order;

public interface OrderState {
    void processOrder(Order order); // Hành vi xử lý tiếp theo
    void cancelOrder(Order order);  // Hành vi hủy
}