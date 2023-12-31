package edu.hw2.task2;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    final public Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    final public Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    final public int area() {
        return this.height * this.width;
    }
}
