package edu.project4.Render;

import edu.project4.FractalImage;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface Renderer {
    FractalImage render(
        FractalImage canvas,
        List<Transformation> variations,
        int samples,
        int iterPerSample,
        long seed,
        boolean symmetry,
        int numberOfSymmetry) throws IllegalAccessException, ExecutionException, InterruptedException;
}
