package edu.project4;

public class LogGammaCorrection {

    public static void correction(FractalImage image) {
        Pixel[][] data = image.getData();

        double max = 0.0;
        double gamma = 2.2;

        for (int row = 0; row < image.getWidth(); row++)
            for (int col=0; col < image.getHeight(); col++)
                if (data[row][col].getHitCount() != 0) {
                    data[row][col].setNormal(Math.log10(data[row][col].getHitCount()));

                    if (data[row][col].getNormal() > max) {
                        max = data[row][col].getNormal();

                    }
                }
        for (int row = 0; row < image.getWidth(); row++)
            for (int col=0; col < image.getHeight(); col++)
            {
                double currentNormal = data[row][col].getNormal();
                data[row][col].setNormal(currentNormal / max);

                Rgb currentRgb = data[row][col].getRgb();

                int newR = (int) (currentRgb.r() * Math.pow(data[row][col].getNormal(),(1.0 / gamma)));
                int newG = (int) (currentRgb.g() * Math.pow(data[row][col].getNormal(),(1.0 / gamma)));
                int newB = (int) (currentRgb.b() * Math.pow(data[row][col].getNormal(),(1.0 / gamma)));
                data[row][col].setRgb(new Rgb(newR, newG, newB));
            }
    }
}
