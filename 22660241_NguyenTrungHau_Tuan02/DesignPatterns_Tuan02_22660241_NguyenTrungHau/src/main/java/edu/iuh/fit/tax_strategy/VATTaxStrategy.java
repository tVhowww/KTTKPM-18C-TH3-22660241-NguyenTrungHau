package edu.iuh.fit.tax_strategy;

public class VATTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        // Thuế Giá trị gia tăng (VAT) mặc định là 10%
        return price * 0.10;
    }
}