package edu.hw2.Task1;

public class Square extends Rectangle {
    public Square(int side) {
        super(side, side);
    }

    public Square() {

    }

    public final Square  setSide(int side) {
        return new Square(side);
    }
}
