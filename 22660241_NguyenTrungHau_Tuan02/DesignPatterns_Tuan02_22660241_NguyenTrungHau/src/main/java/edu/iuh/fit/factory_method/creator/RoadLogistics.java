package edu.iuh.fit.factory_method.creator;

import edu.iuh.fit.factory_method.product.Transport;
import edu.iuh.fit.factory_method.product.Truck;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
