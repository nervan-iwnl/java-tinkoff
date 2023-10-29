package edu.hw2.Task0;

public sealed interface Expr permits Constant, Negative, Exponent, Addition, Multiplication {
    double evaluate();
}
