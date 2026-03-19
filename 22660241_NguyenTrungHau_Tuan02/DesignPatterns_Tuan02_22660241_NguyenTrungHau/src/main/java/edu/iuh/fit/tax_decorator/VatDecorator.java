package edu.iuh.fit.tax_decorator;

class VatDecorator extends TaxDecorator {
    public VatDecorator(ProductComponent p) { super(p); }
    public double getPrice() {
        return wrappedProduct.getPrice() + (wrappedProduct.getPrice() * 0.10);
    }
}
