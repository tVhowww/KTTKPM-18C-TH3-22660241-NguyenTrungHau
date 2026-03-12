package edu.iuh.fit.abstract_factory.product;

public class VictorianChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Ngồi trên ghế Victorian Chair sang trọng.");
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}
