package edu.iuh.fit.order_state;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== KỊCH BẢN 1: Giao hàng thành công ===");
        Order order1 = new Order();
        order1.process(); // Chuyển từ Mới tạo -> Đang xử lý
        order1.process(); // Chuyển từ Đang xử lý -> Đã giao
        order1.process(); // Báo cập nhật thành công
        order1.cancel();  // Cố tình hủy khi đã giao -> Báo lỗi

        System.out.println("\n=== KỊCH BẢN 2: Khách hàng hủy giữa chừng ===");
        Order order2 = new Order();
        order2.process(); // Chuyển từ Mới tạo -> Đang xử lý
        order2.cancel();  // Hủy khi đang xử lý -> Hoàn tiền
        order2.process(); // Cố tình xử lý tiếp -> Báo lỗi
    }
}