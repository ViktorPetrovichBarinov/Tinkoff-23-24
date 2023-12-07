package edu.project4.Transformations;

import edu.project4.Point;

public class PowerTransformation implements Transformation{
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());
        double theta = theta(point.x(), point.y());

        double radiusInSinusTheta = Math.pow(radius, Math.sin(theta));

        double pointX = radiusInSinusTheta * Math.cos(theta);
        double pointY = radiusInSinusTheta * Math.sin(theta);

        return new Point(pointX, pointY);
    }
}
