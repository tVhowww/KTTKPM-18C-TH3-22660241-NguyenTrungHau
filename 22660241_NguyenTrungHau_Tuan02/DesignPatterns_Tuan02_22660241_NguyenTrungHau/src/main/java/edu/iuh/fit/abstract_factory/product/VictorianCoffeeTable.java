package edu.iuh.fit.abstract_factory.product;

public class VictorianCoffeeTable implements CoffeeTable{
    @Override
    public void putCoffee() {
        System.out.println("Đặt bộ ấm trà lên Victorian Coffee Table.");
    }

    @Override
    public String getSize() {
        return "Large";
    }
}
