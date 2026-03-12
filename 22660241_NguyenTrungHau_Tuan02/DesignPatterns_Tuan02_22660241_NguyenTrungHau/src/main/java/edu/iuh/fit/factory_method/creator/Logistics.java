package edu.iuh.fit.factory_method.creator;

import edu.iuh.fit.factory_method.product.Transport;

public abstract class Logistics {
    public void planDelivery() {
        Transport t = createTransport();
        t.deliver();
    }

    public abstract Transport createTransport();
}
