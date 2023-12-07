package edu.project4.Render;

import edu.project4.FractalImage;
import edu.project4.Rect;
import edu.project4.Transformations.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(
        FractalImage canvas,
        List<Transformation> variations,
        int samples,
        int iterPerSample,
        long seed);
}
