package edu.iuh.fit.tax_decorator;

abstract class TaxDecorator implements ProductComponent {
    protected ProductComponent wrappedProduct;
    public TaxDecorator(ProductComponent p) { this.wrappedProduct = p; }
}