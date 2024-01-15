package edu.project4.Transformations;

import edu.project4.Point;

public class CylinderTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double pointX = Math.sin(point.x());
        double pointY = point.y();

        return new Point(pointX, pointY);
    }
}
