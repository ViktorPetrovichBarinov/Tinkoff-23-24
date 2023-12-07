package edu.project4.Transformations;

import edu.project4.Point;

public class FisheyeTransformation implements Transformation{
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());

        double pointX = point.x() * (2 / (radius + 1));
        double pointY = point.y() * (2 / (radius + 1));

        return new Point(pointX, pointY);
    }
}
