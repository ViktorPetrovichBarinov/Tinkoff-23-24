package edu.hw2.Task1;

public record Negate(Expr number) implements Expr {
    @Override
    public double evaluate() {
        return -number.evaluate();
    }
}
