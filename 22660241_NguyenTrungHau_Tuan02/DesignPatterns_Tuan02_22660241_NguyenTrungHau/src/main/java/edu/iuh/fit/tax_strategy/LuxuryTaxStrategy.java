package edu.iuh.fit.tax_strategy;

public class LuxuryTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        // Thuế Tiêu thụ đặc biệt cho hàng xa xỉ là 20%
        return price * 0.20;
    }
}