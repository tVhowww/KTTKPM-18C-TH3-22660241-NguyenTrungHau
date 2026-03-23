package edu.iuh.fit.composite.file_system;

public class File implements FileComponent {
    private String name;
    private int size; // Kích thước tính bằng KB

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + " KB)");
    }
}