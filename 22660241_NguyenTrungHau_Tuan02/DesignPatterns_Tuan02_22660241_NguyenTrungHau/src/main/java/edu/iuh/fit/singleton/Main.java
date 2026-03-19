package edu.iuh.fit.singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Test Lazy Singleton ---");
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();

        // Nếu in ra true nghĩa là 2 biến cùng trỏ về 1 vùng nhớ (chỉ có 1 object)
        System.out.println("instance1 có giống instance2 không? " + (instance1 == instance2));

        System.out.println("\n--- Test Enum Singleton ---");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;

        enum1.setValue(100);
        // Thay đổi giá trị ở enum1, nhưng enum2 cũng bị đổi theo vì chúng là 1
        System.out.println("Giá trị của enum2: " + enum2.getValue());
    }
}