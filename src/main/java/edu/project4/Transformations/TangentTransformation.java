package edu.project4.Transformations;

import edu.project4.Point;

public class TangentTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double pointX = Math.sin(point.x()) / Math.cos(point.y());
        double pointY = Math.atan(point.y());

        return new Point(pointX, pointY);
    }
}
