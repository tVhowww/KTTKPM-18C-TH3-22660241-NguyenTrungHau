package edu.iuh.fit.observer.stock;

public class Main {
    public static void main(String[] args) {
        Stock vinamilk = new Stock("VNM", 68000);

        Observer investor1 = new Investor("Nguyễn Văn A");
        Observer investor2 = new Investor("Trần Thị B");

        // A và B đăng ký theo dõi mã VNM
        vinamilk.attach(investor1);
        vinamilk.attach(investor2);

        System.out.println("=== BIẾN ĐỘNG GIÁ LẦN 1 ===");
        vinamilk.setPrice(69500); // Cả A và B sẽ tự động nhận được tin

        System.out.println("\n=== BIẾN ĐỘNG GIÁ LẦN 2 ===");
        vinamilk.detach(investor1); // A hủy theo dõi
        vinamilk.setPrice(70000); // Lần này chỉ có B nhận được tin
    }
}