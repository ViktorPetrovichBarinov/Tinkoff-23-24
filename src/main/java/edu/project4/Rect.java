package edu.project4;

public record Rect(double x, double y, double width, double height) {
    boolean contains(Point p) {
        double xMax = x + p.x();
        double yMax = y + p.y();

        return p.x() >= x && p.x() <= xMax && p.y() >= y && p.y() <= yMax;
    }

}
