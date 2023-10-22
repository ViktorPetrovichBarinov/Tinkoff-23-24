package edu.hw2.Task1;

public record Multiplication(Expr fst_num, Expr snd_num) implements Expr {
    @Override
    public double evaluate() {
        return fst_num.evaluate() * snd_num.evaluate();
    }
}
