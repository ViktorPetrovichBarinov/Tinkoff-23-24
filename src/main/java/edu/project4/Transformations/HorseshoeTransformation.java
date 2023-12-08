package edu.project4.Transformations;

import edu.project4.Point;

public class HorseshoeTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());

        double pointX = (point.x() - point.y()) * (point.x() + point.y()) / radius;
        double pointY = 2 * point.x() * point.y();

        return new Point(pointX, pointY);
    }
}
