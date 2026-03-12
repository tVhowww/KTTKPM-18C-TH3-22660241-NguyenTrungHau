package edu.iuh.fit.factory_method.product;

public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("Giao hàng bằng đường biển bằng tàu chở container.");
    }
}
