package edu.hw3.Task5;

public record Contact(String name, String surname) {

    public Contact(String name) {
        this(name, "");
    }
}
