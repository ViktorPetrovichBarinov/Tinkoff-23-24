package edu.project4.Transformations;

import edu.project4.Point;

public class CrossTransformation implements Transformation{
    @Override
    public Point apply(Point point) {
        double constant = Math.sqrt(1/(Math.pow(point.x() * point.x() + point.y() * point.y(), 2)));
        double pointX = constant * point.x();
        double pointY = constant * point.y();

        return new Point(pointX, pointY);
    }
}
