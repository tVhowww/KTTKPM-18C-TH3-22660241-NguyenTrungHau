package edu.iuh.fit.composite.ui_components;

import java.util.ArrayList;
import java.util.List;

public class Panel implements UIWidget {
    private String title;
    private List<UIWidget> children;

    public Panel(String title) {
        this.title = title;
        this.children = new ArrayList<>();
    }

    public void addWidget(UIWidget widget) {
        children.add(widget);
    }

    public void removeWidget(UIWidget widget) {
        children.remove(widget);
    }

    @Override
    public void render(String indent) {
        System.out.println(indent + "<Panel: " + title + ">");
        // Gọi đệ quy để vẽ tất cả các thành phần con bên trong Khung này
        for (UIWidget child : children) {
            child.render(indent + "    ");
        }
        System.out.println(indent + "</Panel: " + title + ">");
    }
}