package edu.hw2.Task0;

public record Exponent(Expr expr, double degree) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(expr.evaluate(), degree);
    }
}
