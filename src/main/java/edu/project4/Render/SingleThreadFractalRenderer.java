package edu.project4.Render;

import edu.project4.FractalImage;
import edu.project4.Point;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.Random;

public class SingleThreadFractalRenderer implements Renderer {
    private final static int COUNT_OF_AFFINE_TRANSFORMATION = 50;
    private final static int COUNT_OF_SKIP_RESULTS = 20;

    @Override
    public FractalImage render(
        FractalImage canvas,
        List<Transformation> variations,
        int samples,
        int iterPerSample,
        long seed,
        boolean symmetry,
        int numberOfSymmetry
    ) throws IllegalAccessException {

        Random random = new Random(seed);
        AffineTransformationGenerator generator =
            new AffineTransformationGenerator(COUNT_OF_AFFINE_TRANSFORMATION, seed);
        List<AffineTransformation> affineTransformationList = generator.affineTransformationsGenerator();

        for (int i = 0; i < samples; i++) {
            Point point = new Point(0.0, 0.0);

            for (int j = -COUNT_OF_SKIP_RESULTS; j < iterPerSample; j++) {
                //получаем рандомное линейное преобразование
                int currentTransformationIndex = random.nextInt(affineTransformationList.size());
                AffineTransformation curTransformation = affineTransformationList.get(currentTransformationIndex);

                //преобразовываем
                double pointX = point.x() * curTransformation.a()
                    + point.y() * curTransformation.b() + curTransformation.c();
                double pointY = point.x() * curTransformation.d()
                    + point.y() * curTransformation.e() + curTransformation.f();
                point = new Point(pointX, pointY);

                int currentVariationIndex = random.nextInt(variations.size());
                Transformation variation = variations.get(currentVariationIndex);
                point = variation.apply(point);

                if (symmetry) {
                    double angleOfRotation = 0;


                    if (numberOfSymmetry < 1) {
                        throw new IllegalAccessException();
                    }

                    for (int k = 0; k < numberOfSymmetry; k++) {
                        angleOfRotation = 2 * Math.PI * k / numberOfSymmetry;
                        double rotationPointX = point.x() * Math.cos(angleOfRotation)
                            - point.y() * Math.sin(angleOfRotation);
                        double rotationPointY = point.x() * Math.sin(angleOfRotation)
                            + point.y() * Math.cos(angleOfRotation);
                        if (j < 0 || Math.abs(rotationPointX) > 1 || Math.abs(rotationPointY) > 1) {
                            continue;
                        }

                        Point rotationPoint = new Point((rotationPointX + 1) / 2 * canvas.getWidth(),
                            (rotationPointY + 1) / 2 * canvas.getHeight());

                        canvas.update(rotationPoint, curTransformation.rgb());
                    }
                } else {
                    if (j < 0 || Math.abs(point.x()) > 1 || Math.abs(point.y()) > 1) {
                        continue;
                    }

                    Point drawPoint = new Point((point.x() + 1) / 2 * canvas.getWidth(),
                        (point.y() + 1) / 2 * canvas.getHeight());
                    canvas.update(drawPoint, curTransformation.rgb());
                }
            }
        }

        return canvas;
    }
}
