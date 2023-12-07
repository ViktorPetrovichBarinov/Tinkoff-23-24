package edu.project4.Render;

import edu.project4.FractalImage;
import edu.project4.Pixel;
import edu.project4.Point;
import edu.project4.Rect;
import edu.project4.Rgb;
import edu.project4.Transformations.Transformation;
import java.util.List;
import java.util.Random;

public class SingleThreadFractalRenderer implements Renderer{
    @Override
    public FractalImage render(
        FractalImage canvas,
        List<Transformation> variations,
        int samples,
        int iterPerSample,
        long seed
    ) {

        Random random = new Random(seed);
        AffineTransformationGenerator generator = new AffineTransformationGenerator(50, seed);
        List<AffineTransformation> affineTransformationList = generator.affineTransformationsGenerator();

        for (int i = 0; i < samples; i++) {
            Point point = new Point(0.0, 0.0);

            for (int j = -20; j < iterPerSample; j++) {
                //получаем рандомное линейное преобразование
                int currentTransformationIndex = random.nextInt(affineTransformationList.size());
                AffineTransformation curTransformation = affineTransformationList.get(currentTransformationIndex);

                //преобразовываем
                double pointX = point.x() * curTransformation.a() + point.y() * curTransformation.b() + curTransformation.c();
                double pointY = point.x() * curTransformation.d() + point.y() * curTransformation.e() + curTransformation.f();
                point = new Point(pointX, pointY);

                int currentVariationIndex = random.nextInt(variations.size());
                Transformation variation = variations.get(currentVariationIndex);
                point = variation.apply(point);
                if (j < 0 || point.x() > 1 || point.y() > 1 || point.x() < -1 || point.y() < -1) {
                    continue;
                }

                Point drawPoint = new Point((point.x() + 1) / 2 * canvas.getWidth(), (point.y() + 1) / 2 * canvas.getHeight());
                canvas.update(drawPoint, curTransformation.rgb());
            }
        }

        return canvas;
    }
}
