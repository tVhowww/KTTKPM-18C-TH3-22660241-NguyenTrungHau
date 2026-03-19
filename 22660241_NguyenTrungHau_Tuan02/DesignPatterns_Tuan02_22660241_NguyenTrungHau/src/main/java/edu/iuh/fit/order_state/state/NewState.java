package edu.iuh.fit.order_state.state;
import edu.iuh.fit.order_state.Order;

public class NewState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("[MỚI TẠO] -> Đang kiểm tra thông tin đơn hàng... Hợp lệ!");
        // Chuyển sang trạng thái Đang xử lý
        order.setState(new ProcessingState());
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("[MỚI TẠO] -> Đã hủy đơn hàng thành công.");
        order.setState(new CancelledState());
    }
}