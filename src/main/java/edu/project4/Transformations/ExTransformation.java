package edu.project4.Transformations;

import edu.project4.Point;

public class ExTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());
        double theta = theta(point.x(), point.y());

        double p0 = Math.sin(theta + radius);
        double p1 = Math.cos(theta - radius);

        double pointX = radius * (p0 * p0 * p0 + p1 * p1 * p1);
        double pointY = radius * (p0 * p0 * p0 - p1 * p1 * p1);

        return new Point(pointX, pointY);
    }
}
