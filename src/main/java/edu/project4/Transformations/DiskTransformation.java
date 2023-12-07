package edu.project4.Transformations;

import edu.project4.Point;

public class DiskTransformation implements Transformation{
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());
        double theta = theta(point.x(), point.y());

        double pointX = (theta / Math.PI) * Math.sin(Math.PI * radius);
        double pointY = (theta / Math.PI) * Math.cos(Math.PI * radius);

        return new Point(pointX, pointY);
    }
}
