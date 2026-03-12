package edu.iuh.fit.factory_method.creator;

import edu.iuh.fit.factory_method.product.Ship;
import edu.iuh.fit.factory_method.product.Transport;

public class SeaLogistics extends Logistics{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
