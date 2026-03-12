package edu.iuh.fit.factory_method.client;

import edu.iuh.fit.factory_method.creator.Logistics;
import edu.iuh.fit.factory_method.creator.RoadLogistics;
import edu.iuh.fit.factory_method.creator.SeaLogistics;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Test Road Logistics ---");
        Logistics log = new RoadLogistics();
        log.planDelivery();

        System.out.println("\n--- Test Sea Logistics ---");
        Logistics seaLog = new SeaLogistics();
        seaLog.planDelivery();
    }
}