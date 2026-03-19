package edu.iuh.fit.tax_state;

class Product {
    private TaxState state;
    private double price = 100000;

    public void setState(TaxState state) { this.state = state; }

    public void calculateFinalPrice() {
        double tax = state.applyTax(this, price);
        System.out.println("Tổng: " + (price + tax));
    }
}