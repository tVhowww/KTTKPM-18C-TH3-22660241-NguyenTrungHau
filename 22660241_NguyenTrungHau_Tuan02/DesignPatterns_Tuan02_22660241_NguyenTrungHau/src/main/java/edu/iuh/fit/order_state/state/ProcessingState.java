package edu.iuh.fit.order_state.state;
import edu.iuh.fit.order_state.Order;

public class ProcessingState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("[ĐANG XỬ LÝ] -> Đang đóng gói và vận chuyển hàng hóa...");
        // Chuyển sang trạng thái Đã giao
        order.setState(new DeliveredState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[ĐANG XỬ LÝ] -> Hủy đơn hàng. Bắt đầu quy trình hoàn tiền cho khách.");
        order.setState(new CancelledState());
    }
}