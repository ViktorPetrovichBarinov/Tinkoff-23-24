package edu.project4.Transformations;

import edu.project4.Point;

public class HandkerchiefTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());
        double theta = theta(point.x(), point.y());

        double pointX = Math.sin(theta + radius) * radius;
        double pointY = Math.cos(theta - radius) * radius;

        return new Point(pointX, pointY);
    }
}
