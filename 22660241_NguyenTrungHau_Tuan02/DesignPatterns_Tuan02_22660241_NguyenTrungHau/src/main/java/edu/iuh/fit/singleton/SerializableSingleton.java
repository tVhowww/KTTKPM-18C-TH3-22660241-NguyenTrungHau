package edu.iuh.fit.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    private SerializableSingleton() {}

    private static class SingletonHelper {
        static final SerializableSingleton INSTANCE = new SerializableSingleton();
    }

    public static SerializableSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private Object readResolve() {
        return SingletonHelper.INSTANCE;
    }
}