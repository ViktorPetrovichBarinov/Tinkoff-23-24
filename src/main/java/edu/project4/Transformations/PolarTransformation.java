package edu.project4.Transformations;

import edu.project4.Point;

public class PolarTransformation implements Transformation{
    @Override
    public Point apply(Point point) {
        double theta = theta(point.x(), point.y());
        double radius = radius(point.x(), point.y());

        return new Point(theta / Math.PI, radius - 1);
    }
}
