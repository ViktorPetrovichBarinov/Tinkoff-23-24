package edu.project4;


import edu.project4.Render.MultiThreadFractalRenderer;
import edu.project4.Render.SingleThreadFractalRenderer;
import edu.project4.Transformations.ExponentialTransformation;
import edu.project4.Transformations.Transformation;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private Main() {

    }

    private final static int WIDTH = 1080;
    private final static int HEIGHT = 1080;
    private final static int SAMPLES = 1000000;
    private final static int ITER_PER_SAMPLES = 20;
    private final static long SEED = 123450678L;
    private final static boolean SYMMETRY = true;
    private final static int NUMBER_OF_SYMMETRY = 5;
    private final static int NUMBER_OF_THREADS = 6;
    private final static Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings({"RegexpSinglelineJava", "MagicNumber"})
    public static void main(String[] args) throws IllegalAccessException {
        long start;
        long end;

        start = System.currentTimeMillis();
        FractalImage fractalImage = new FractalImage(WIDTH, HEIGHT);
        SingleThreadFractalRenderer renderer = new SingleThreadFractalRenderer();

        List<Transformation> transformationsList = new ArrayList<>();
        transformationsList.add(new ExponentialTransformation());




        renderer.render(
            fractalImage, transformationsList, SAMPLES, ITER_PER_SAMPLES, SEED, SYMMETRY, NUMBER_OF_SYMMETRY);
        end = System.currentTimeMillis();
        LOGGER.info("Single thread time: {}", (end - start));

        ImageUtils.save(fractalImage, Path.of("1.png"), ImageFormat.PNG);


        start = System.currentTimeMillis();
        FractalImage fractalImageMulti = new FractalImage(WIDTH, HEIGHT);
        MultiThreadFractalRenderer rendererMulti = new MultiThreadFractalRenderer(NUMBER_OF_THREADS);


        rendererMulti.render(
            fractalImageMulti, transformationsList, SAMPLES, ITER_PER_SAMPLES, SEED, SYMMETRY, NUMBER_OF_SYMMETRY);
        end = System.currentTimeMillis();
        LOGGER.info("{} threads time: {}", NUMBER_OF_THREADS,  (end - start));


        ImageUtils.save(fractalImageMulti, Path.of("2.png"), ImageFormat.PNG);
    }
}
