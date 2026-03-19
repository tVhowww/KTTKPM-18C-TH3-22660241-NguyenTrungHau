package edu.iuh.fit.order_state.state;
import edu.iuh.fit.order_state.Order;

public class DeliveredState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("[ĐÃ GIAO] -> Cập nhật trạng thái: Đơn hàng đã giao thành công tới tay khách hàng.");
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[ĐÃ GIAO] -> LỖI: Không thể hủy đơn hàng vì hàng đã được giao.");
    }
}