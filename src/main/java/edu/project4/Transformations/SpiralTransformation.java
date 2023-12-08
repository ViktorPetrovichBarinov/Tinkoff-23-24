package edu.project4.Transformations;

import edu.project4.Point;

public class SpiralTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());
        double theta = theta(point.x(), point.y());

        double pointX = (Math.cos(theta) + Math.sin(radius)) / radius;
        double pointY = (Math.sin(theta) - Math.cos(radius)) / radius;

        return new Point(pointX, pointY);
    }
}
