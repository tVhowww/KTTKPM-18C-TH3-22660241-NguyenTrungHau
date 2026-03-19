package edu.iuh.fit.tax_decorator;

public class Main {
    public static void main(String[] args) {
        ProductComponent item = new BasicProduct();

        // Hợp lý
        ProductComponent taxedItem = new VatDecorator(item);

        // VÔ LÝ: Lập trình viên lỡ tay bọc VAT 3 lần, bọc thêm Thuế Xa xỉ, code vẫn chạy bình thường!
        ProductComponent bugItem = new VatDecorator(new VatDecorator(new LuxuryDecorator(item)));
        System.out.println("Giá lỗi do Decorator cho phép bọc vô hạn: " + bugItem.getPrice());
    }
}