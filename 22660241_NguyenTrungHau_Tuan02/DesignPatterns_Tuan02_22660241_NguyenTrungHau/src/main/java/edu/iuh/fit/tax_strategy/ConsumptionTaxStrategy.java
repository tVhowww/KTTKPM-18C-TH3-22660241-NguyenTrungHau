package edu.iuh.fit.tax_strategy;

public class ConsumptionTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        // Thuế Tiêu thụ thông thường là 5%
        return price * 0.05;
    }
}