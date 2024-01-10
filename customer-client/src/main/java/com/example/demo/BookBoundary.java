package com.example.demo;

public class BookBoundary {
    private String id;

    public BookBoundary() {
    }

    public BookBoundary(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book : " + this.id;
    }
}
