package edu.iuh.fit.abstract_factory.factory;

import edu.iuh.fit.abstract_factory.product.*;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() { return new ModernChair(); }
    @Override
    public Sofa createSofa() { return new ModernSofa(); }
    @Override
    public CoffeeTable createCoffeeTable() { return new ModernCoffeeTable(); }
}