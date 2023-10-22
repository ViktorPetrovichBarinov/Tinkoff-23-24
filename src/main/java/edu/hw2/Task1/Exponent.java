package edu.hw2.Task1;

public record Exponent(Expr number, double pow) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(number.evaluate(), pow);
    }
}
