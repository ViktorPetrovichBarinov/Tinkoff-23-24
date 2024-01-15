package edu.project4.Transformations;

import edu.project4.Point;

public class HyperbolicTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());
        double theta = theta(point.x(), point.y());

        double pointX = Math.sin(theta) / radius;
        double pointY = radius * Math.cos(theta);

        return new Point(pointX, pointY);
    }
}
