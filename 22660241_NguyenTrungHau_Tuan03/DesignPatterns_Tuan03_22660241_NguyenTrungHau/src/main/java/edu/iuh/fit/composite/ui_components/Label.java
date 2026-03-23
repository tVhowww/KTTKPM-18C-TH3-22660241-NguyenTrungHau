package edu.iuh.fit.composite.ui_components;

public class Label implements UIWidget {
    private String text;

    public Label(String text) {
        this.text = text;
    }

    @Override
    public void render(String indent) {
        System.out.println(indent + "(Label) " + text);
    }
}