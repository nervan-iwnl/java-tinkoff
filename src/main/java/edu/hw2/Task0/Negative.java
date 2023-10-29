package edu.hw2.Task0;

public record Negative(Expr expr) implements Expr {
    @Override
    public double evaluate() {
        return -expr.evaluate();
    }
}
