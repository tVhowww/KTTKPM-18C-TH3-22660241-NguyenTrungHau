package edu.iuh.fit.abstract_factory.factory;

import edu.iuh.fit.abstract_factory.product.Chair;
import edu.iuh.fit.abstract_factory.product.CoffeeTable;
import edu.iuh.fit.abstract_factory.product.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}
