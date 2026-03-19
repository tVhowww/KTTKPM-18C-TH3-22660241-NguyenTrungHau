package edu.iuh.fit.singleton;

public class EagerSingleton {
    // Static member to hold the single instance
    private static EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent external instantiation
    private EagerSingleton() { }

    // Static factory method for global access
    public static EagerSingleton getInstance() {
        return instance;
    }
}