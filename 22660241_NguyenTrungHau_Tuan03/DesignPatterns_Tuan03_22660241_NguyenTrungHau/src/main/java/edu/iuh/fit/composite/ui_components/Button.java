package edu.iuh.fit.composite.ui_components;

public class Button implements UIWidget {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void render(String indent) {
        System.out.println(indent + "[Button] " + label);
    }
}