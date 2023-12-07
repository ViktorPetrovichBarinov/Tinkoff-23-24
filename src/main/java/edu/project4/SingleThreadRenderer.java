package edu.project4;

import edu.project4.Transformations.Transformation;
import java.util.List;

public class SingleThreadRenderer implements Renderer{
    @Override
    public FractalImage render(
        FractalImage canvas, // холст
        Rect world, // область в которой будет отрисовываться фрактал
        List<Transformation> variations, // список трансформаций
        int samples, // количество точек для генерации фрактала
        short iterPerSample, // количество итераций, для каждой точки
        long seed // это для генератора случайных величин
    ) {
        return null;
    }


}
