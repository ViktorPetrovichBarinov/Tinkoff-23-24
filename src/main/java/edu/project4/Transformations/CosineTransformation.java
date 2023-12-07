package edu.project4.Transformations;

import edu.project4.Point;

public class CosineTransformation implements Transformation{
    @Override
    public Point apply(Point point) {

        double pointX = Math.cos(Math.PI * point.x()) * Math.cosh(point.y());
        double pointY = Math.sin(Math.PI * point.x()) * Math.sinh(point.y());

        return new Point(pointX, pointY);
    }
}
