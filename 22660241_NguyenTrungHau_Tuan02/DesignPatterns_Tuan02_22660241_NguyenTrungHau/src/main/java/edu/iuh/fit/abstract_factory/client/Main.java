package edu.iuh.fit.abstract_factory.client;

import edu.iuh.fit.abstract_factory.factory.FurnitureFactory;
import edu.iuh.fit.abstract_factory.factory.ModernFurnitureFactory;
import edu.iuh.fit.abstract_factory.factory.VictorianFurnitureFactory;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Setup Modern Room ---");
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        InteriorDesigner modernRoom = new InteriorDesigner(modernFactory);
        modernRoom.decorate();

        System.out.println("\n--- Setup Victorian Room ---");
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        InteriorDesigner victorianRoom = new InteriorDesigner(victorianFactory);
        victorianRoom.decorate();
    }
}