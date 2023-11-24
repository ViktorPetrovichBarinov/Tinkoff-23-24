package edu.hw2.task1;

public record Multiplication(Expr fstNum, Expr sndNum) implements Expr {
    @Override
    public double evaluate() {
        return fstNum.evaluate() * sndNum.evaluate();
    }
}
