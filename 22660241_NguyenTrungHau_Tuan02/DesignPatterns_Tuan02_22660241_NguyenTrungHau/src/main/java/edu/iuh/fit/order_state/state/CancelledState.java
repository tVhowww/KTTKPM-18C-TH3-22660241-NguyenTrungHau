package edu.iuh.fit.order_state.state;
import edu.iuh.fit.order_state.Order;

public class CancelledState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("[ĐÃ HỦY] -> LỖI: Đơn hàng đã bị hủy, không thể xử lý tiếp. Vui lòng tạo đơn mới.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[ĐÃ HỦY] -> Đơn hàng này đã được hủy trước đó và đã hoàn tiền.");
    }
}