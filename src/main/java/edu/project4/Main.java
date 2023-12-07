package edu.project4;

import edu.project4.Render.SingleThreadFractalRenderer;
import edu.project4.Transformations.BubbleTransformation;
import edu.project4.Transformations.CosineTransformation;
import edu.project4.Transformations.CrossTransformation;
import edu.project4.Transformations.CylinderTransformation;
import edu.project4.Transformations.DiamondTransformation;
import edu.project4.Transformations.DiskTransformation;
import edu.project4.Transformations.ExTransformation;
import edu.project4.Transformations.ExponentialTransformation;
import edu.project4.Transformations.HandkerchiefTransformation;
import edu.project4.Transformations.HorseshoeTransformation;
import edu.project4.Transformations.PowerTransformation;
import edu.project4.Transformations.SphericalTransformation;
import edu.project4.Transformations.SpiralTransformation;
import edu.project4.Transformations.SwirlTransformation;
import edu.project4.Transformations.TangentTransformation;
import edu.project4.Transformations.Transformation;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FractalImage fractalImage = new FractalImage(1080, 1080);
        SingleThreadFractalRenderer renderer = new SingleThreadFractalRenderer();

        List<Transformation> transformationsList = new ArrayList<>();
        transformationsList.add(new PowerTransformation());
        //transformationsList.add(new HandkerchiefTransformation());

        fractalImage = renderer.render(fractalImage, transformationsList, 1000000, 50, new Random().nextLong());

        ImageUtils.save(fractalImage, Path.of("1.png"), ImageFormat.PNG);
    }
}
