package edu.project4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private ImageUtils() {}

    private static final int RED_SHIFT = 16;
    private static final int GREEN_SHIFT = 8;

    public static void save(FractalImage image, Path filename, ImageFormat format) {
        BufferedImage imageOut = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Pixel[][] data = image.getData();
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Rgb currentRgb = data[i][j].getRgb();
                int r = currentRgb.r();
                int g = currentRgb.g();
                int b = currentRgb.b();
                imageOut.setRGB(i, j, (r << RED_SHIFT) + (g << GREEN_SHIFT) + b);
            }
        }

        File outputfile = new File("src/main/java/edu/project4/" + filename.toString());

        try {
            ImageIO.write(imageOut, format.toString(), outputfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
