package edu.iuh.fit.singleton;

public class BillPughSingleton {
    private BillPughSingleton() { }

    private static class SingletonHelper {
        static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}