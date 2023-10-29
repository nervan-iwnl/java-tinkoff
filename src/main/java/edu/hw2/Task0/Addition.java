package edu.hw2.Task0;

public record Addition(Expr ex1, Expr ex2) implements Expr  {
    @Override
    public double evaluate() {
        return ex1.evaluate() + ex2.evaluate();
    }
}

