package edu.iuh.fit.abstract_factory.product;

public class ModernCoffeeTable implements CoffeeTable{
    @Override
    public void putCoffee() {
        System.out.println("Đặt ly cà phê lên Modern Coffee Table.");
    }

    @Override
    public String getSize() {
        return "Medium";
    }
}
