package edu.hw2.Task1;

public record Addition(Expr fstNum, Expr sndNum) implements Expr {
    @Override
    public double evaluate() {
        return fstNum.evaluate() + sndNum.evaluate();
    }
}
