package edu.project4.Transformations;

import edu.project4.Point;

public class SwirlTransformation implements Transformation{

    @Override
    public Point apply(Point point) {
        double radiusInSquare = radius(point.x(), point.y());
        radiusInSquare *= radiusInSquare;

        double pointX = point.x() * Math.sin(radiusInSquare) - point.y() * Math.cos(radiusInSquare);
        double pointY = point.x() * Math.cos(radiusInSquare) + point.y() * Math.sin(radiusInSquare);

        return new Point(pointX, pointY);
    }
}
