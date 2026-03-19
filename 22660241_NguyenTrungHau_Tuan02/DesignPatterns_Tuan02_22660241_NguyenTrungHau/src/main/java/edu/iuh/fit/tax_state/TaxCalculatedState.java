package edu.iuh.fit.tax_state;

class TaxCalculatedState implements TaxState {
    public double applyTax(Product context, double basePrice) {
        System.out.println("Lỗi: Sản phẩm đã được tính thuế rồi, không tính nữa!");
        return 0;
    }
}