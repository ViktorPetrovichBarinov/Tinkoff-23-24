package edu.project4;

import edu.project4.Transformations.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(FractalImage canvas, Rect world, List<Transformation> variations, int samples, short iterPerSample, long seed);
}
