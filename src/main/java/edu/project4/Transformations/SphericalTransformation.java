package edu.project4.Transformations;

import edu.project4.Point;

public class SphericalTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double radiusIsSquared = radius(point.x(), point.y());
        radiusIsSquared *= radiusIsSquared;
        double newX = point.x() / radiusIsSquared;
        double newY = point.y()  / radiusIsSquared;
        return new Point(newX, newY);
    }
}
