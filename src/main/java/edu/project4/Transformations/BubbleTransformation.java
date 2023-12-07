package edu.project4.Transformations;

import edu.project4.Point;

public class BubbleTransformation implements Transformation{
    @Override
    public Point apply(Point point) {
        double radius = radius(point.x(), point.y());

        double pointX = point.x() * (4 / (radius * radius + 4));
        double pointY = point.y() * (4 / (radius * radius + 4));

        return new Point(pointX, pointY);
    }
}
