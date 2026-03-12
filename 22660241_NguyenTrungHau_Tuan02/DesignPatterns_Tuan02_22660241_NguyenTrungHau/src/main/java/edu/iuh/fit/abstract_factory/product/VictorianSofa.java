package edu.iuh.fit.abstract_factory.product;

public class VictorianSofa implements Sofa{
    @Override
    public void lieOn() {
        System.out.println("Nằm trên Victorian Sofa cổ điển.");
    }

    @Override
    public boolean isComfortable() {
        return true;
    }
}
