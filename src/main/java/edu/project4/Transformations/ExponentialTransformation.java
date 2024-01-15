package edu.project4.Transformations;

import edu.project4.Point;

public class ExponentialTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());

        double pointX = Math.pow(Math.E, point.x() - 1) * Math.cos(Math.PI * point.y());
        double pointY = Math.pow(Math.E, point.x() - 1) * Math.sin(Math.PI * point.y());

        return new Point(pointX, pointY);
    }
}
