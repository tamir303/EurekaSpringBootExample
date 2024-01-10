package com.example.demo;

import java.util.UUID;

public class BookBoundary {
    private String id;

    public BookBoundary() {
    }

    public BookBoundary(int id) {
        this.id = UUID.randomUUID().toString();
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
