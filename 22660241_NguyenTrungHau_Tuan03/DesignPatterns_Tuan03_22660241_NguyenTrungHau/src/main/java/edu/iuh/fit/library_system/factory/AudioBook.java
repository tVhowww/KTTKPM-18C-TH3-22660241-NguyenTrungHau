package edu.iuh.fit.library_system.factory;

public class AudioBook implements Book {
    private String title, author, category;

    public AudioBook(String title, String author, String category) {
        this.title = title; this.author = author; this.category = category;
    }

    @Override public String getTitle() { return title; }
    @Override public String getAuthor() { return author; }
    @Override public String getCategory() { return category; }
    @Override public void display() { System.out.println("Sách Nói: " + title + " - " + author); }
}