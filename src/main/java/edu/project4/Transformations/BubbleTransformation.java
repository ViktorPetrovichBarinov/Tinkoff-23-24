package edu.project4.Transformations;

import edu.project4.Point;

public class BubbleTransformation implements Transformation {
    private final static int CONST = 4;

    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());

        double pointX = point.x() * (CONST / (radius * radius + CONST));
        double pointY = point.y() * (CONST / (radius * radius + CONST));

        return new Point(pointX, pointY);
    }
}
