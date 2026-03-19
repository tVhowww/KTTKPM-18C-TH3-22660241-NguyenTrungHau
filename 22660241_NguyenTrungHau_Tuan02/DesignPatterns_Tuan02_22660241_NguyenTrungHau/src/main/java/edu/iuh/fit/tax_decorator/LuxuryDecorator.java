package edu.iuh.fit.tax_decorator;

class LuxuryDecorator extends TaxDecorator {
    public LuxuryDecorator(ProductComponent p) { super(p); }
    public double getPrice() {
        return wrappedProduct.getPrice() + (wrappedProduct.getPrice() * 0.20);
    }
}