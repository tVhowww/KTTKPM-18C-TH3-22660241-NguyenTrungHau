package edu.iuh.fit.tax_strategy;

public class Product {
    private String name;
    private double basePrice;
    private TaxStrategy taxStrategy;

    // Khi tạo sản phẩm, có thể gắn ngay một loại thuế cho nó
    public Product(String name, double basePrice, TaxStrategy taxStrategy) {
        this.name = name;
        this.basePrice = basePrice;
        this.taxStrategy = taxStrategy;
    }

    // Cho phép thay đổi loại thuế lúc chương trình đang chạy (Runtime)
    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public double getFinalPrice() {
        double tax = taxStrategy.calculateTax(basePrice);
        return basePrice + tax;
    }

    public void printReceipt() {
        double tax = taxStrategy.calculateTax(basePrice);
        System.out.println("Sản phẩm: " + name);
        System.out.println("- Giá gốc: " + basePrice + " VNĐ");
        System.out.println("- Tiền thuế: " + tax + " VNĐ");
        System.out.println("- TỔNG THANH TOÁN: " + getFinalPrice() + " VNĐ\n");
    }
}