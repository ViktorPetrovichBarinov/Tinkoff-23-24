package edu.project4;

import edu.project4.Render.MultiThreadFractalRenderer;
import edu.project4.Render.Renderer;
import edu.project4.Render.SingleThreadFractalRenderer;
import edu.project4.Transformations.BubbleTransformation;
import edu.project4.Transformations.CosineTransformation;
import edu.project4.Transformations.CrossTransformation;
import edu.project4.Transformations.CylinderTransformation;
import edu.project4.Transformations.DiamondTransformation;
import edu.project4.Transformations.DiskTransformation;
import edu.project4.Transformations.ExTransformation;
import edu.project4.Transformations.ExponentialTransformation;
import edu.project4.Transformations.FisheyeTransformation;
import edu.project4.Transformations.HandkerchiefTransformation;
import edu.project4.Transformations.HeartTransformation;

import edu.project4.Transformations.HorseshoeTransformation;
import edu.project4.Transformations.HyperbolicTransformation;
import edu.project4.Transformations.PolarTransformation;
import edu.project4.Transformations.PowerTransformation;
import edu.project4.Transformations.SinusoidalTransformation;
import edu.project4.Transformations.SphericalTransformation;
import edu.project4.Transformations.SpiralTransformation;
import edu.project4.Transformations.SwirlTransformation;
import edu.project4.Transformations.TangentTransformation;
import edu.project4.Transformations.Transformation;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static edu.project4.LogGammaCorrection.correction;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        long start, end;



        start = System.currentTimeMillis();
        FractalImage fractalImage = new FractalImage(1080, 1080);
        SingleThreadFractalRenderer renderer = new SingleThreadFractalRenderer();

        List<Transformation> transformationsList = new ArrayList<>();
        transformationsList.add(new ExponentialTransformation());


        renderer.render(
            fractalImage, transformationsList, 1000000, 20, /*new Random().nextLong()*/  123450678L, true, 5);
        end = System.currentTimeMillis();
        System.out.println("Single thread time: " + (end - start));

        ImageUtils.save(fractalImage, Path.of("1.png"), ImageFormat.PNG);


        start = System.currentTimeMillis();
        FractalImage fractalImageMulti = new FractalImage(1080, 1080);
        MultiThreadFractalRenderer rendererMulti = new MultiThreadFractalRenderer(6);


        rendererMulti.render(
            fractalImageMulti, transformationsList, 1000000, 20, /*new Random().nextLong()*/  123450678L, true, 15);
        end = System.currentTimeMillis();
        System.out.println("6 threads time: " + (end - start));


        ImageUtils.save(fractalImageMulti, Path.of("2.png"), ImageFormat.PNG);








    }
}
