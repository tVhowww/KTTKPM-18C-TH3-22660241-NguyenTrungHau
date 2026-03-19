package edu.iuh.fit.tax_strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG TÍNH THUẾ SẢN PHẨM ===\n");

        // 1. Sản phẩm thiết yếu -> Thuế VAT 10%
        Product milk = new Product("Thùng Sữa Tươi", 300000, new VATTaxStrategy());
        milk.printReceipt();

        // 2. Sản phẩm phổ thông -> Thuế tiêu thụ 5%
        Product shirt = new Product("Áo thun Cotton", 200000, new ConsumptionTaxStrategy());
        shirt.printReceipt();

        // 3. Sản phẩm xa xỉ -> Thuế đặc biệt 20%
        Product rolex = new Product("Đồng hồ Rolex", 500000000, new LuxuryTaxStrategy());
        rolex.printReceipt();

        // 4. Linh hoạt thay đổi thuế: Giả sử Rolex được giảm thuế xuống mức VAT 10% trong dịp lễ
        System.out.println("=== CẬP NHẬT: ROLEX ĐƯỢC ÁP DỤNG THUẾ VAT DỊP LỄ ===");
        rolex.setTaxStrategy(new VATTaxStrategy()); // Chuyển đổi chiến lược
        rolex.printReceipt();
    }
}
// KẾT LUẬN:
//    Bằng cách áp dụng Strategy Pattern, thuật toán tính toán các loại thuế (VAT, Tiêu thụ, Xa xỉ)
//    được đóng gói thành các class riêng biệt thực thi cùng một interface.
//    Điều này giúp class Product trở nên gọn nhẹ, không bị phình to bởi các câu
//    lệnh if-else kiểm tra loại hình thuế. Hệ thống có thể dễ dàng thêm các loại thuế
//    mới trong tương lai (ví dụ: Thuế môi trường) mà không cần sửa đổi mã nguồn gốc
//    của lớp Product hay các lớp hình thuế hiện tại, tuân thủ tuyệt đối nguyên lý Open/Closed
//    (Mở rộng nhưng Đóng sửa đổi)