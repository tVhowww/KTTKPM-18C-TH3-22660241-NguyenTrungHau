package edu.iuh.fit.abstract_factory.product;

public class ModernChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Ngồi trên ghế Modern Chair.");
    }

    @Override
    public boolean hasLegs() {
        return false;
    }
}
