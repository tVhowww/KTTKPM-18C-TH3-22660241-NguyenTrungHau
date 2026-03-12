package edu.iuh.fit.abstract_factory.product;

public class ModernSofa implements Sofa{
    @Override
    public void lieOn() {
        System.out.println("Nằm trên Modern Sofa.");
    }

    @Override
    public boolean isComfortable() {
        return true;
    }
}
