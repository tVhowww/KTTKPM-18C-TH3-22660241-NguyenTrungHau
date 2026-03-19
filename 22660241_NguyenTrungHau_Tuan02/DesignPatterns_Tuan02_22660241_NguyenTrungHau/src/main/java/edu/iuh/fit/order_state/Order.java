package edu.iuh.fit.order_state;
import edu.iuh.fit.order_state.state.NewState;
import edu.iuh.fit.order_state.state.OrderState;

public class Order {
    private OrderState state;

    public Order() {
        // Khi mới tạo ra, đơn hàng mặc định ở trạng thái NewState
        this.state = new NewState();
        System.out.println("--- Đơn hàng vừa được khởi tạo ---");
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    // Ủy quyền (Delegate) các hành vi cho đối tượng State hiện tại xử lý
    public void process() {
        state.processOrder(this);
    }

    public void cancel() {
        state.cancelOrder(this);
    }
}