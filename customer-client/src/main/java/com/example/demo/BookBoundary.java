package com.example.demo;

public class BookBoundary {
    private int id;

    public BookBoundary() {
    }

    public BookBoundary(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book" + this.id;
    }
}
