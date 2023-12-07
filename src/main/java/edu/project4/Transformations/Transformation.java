package edu.project4.Transformations;

import edu.project4.Point;
import java.util.function.Function;

public interface Transformation extends Function<Point, Point> {

    default double radius(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    default double theta(double x, double y) {
        return Math.atan(x/y);
    }

    default double phi(double x, double y) {
        return Math.atan(y/x);
    }


}
