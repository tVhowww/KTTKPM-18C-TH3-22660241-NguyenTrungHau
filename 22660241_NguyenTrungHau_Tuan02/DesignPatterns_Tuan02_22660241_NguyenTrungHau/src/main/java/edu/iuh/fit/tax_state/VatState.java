package edu.iuh.fit.tax_state;

class VatState implements TaxState {
    public double applyTax(Product context, double basePrice) {
        System.out.println("Đang ở trạng thái VAT. Tính thêm 10%.");
        // Ép chuyển trạng thái vô nghĩa (để ra dáng State Pattern)
        context.setState(new TaxCalculatedState());
        return basePrice * 0.10;
    }
}