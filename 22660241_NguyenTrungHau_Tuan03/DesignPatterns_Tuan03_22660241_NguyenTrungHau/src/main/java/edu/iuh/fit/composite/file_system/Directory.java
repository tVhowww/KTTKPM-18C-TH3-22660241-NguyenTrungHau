package edu.iuh.fit.composite.file_system;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileComponent {
    private String name;
    private List<FileComponent> components;

    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(FileComponent component) {
        components.add(component);
    }

    public void removeComponent(FileComponent component) {
        components.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Directory: " + name);
        // Duyệt qua tất cả các thành phần con và gọi display() của chúng
        for (FileComponent component : components) {
            component.display(indent + "____"); // Thêm khoảng trắng để thụt lề cho con
        }
    }
}