package edu.project4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public final class ImageUtils {
    private ImageUtils() {}

    public static void save(FractalImage image, Path filename, ImageFormat format){
        BufferedImage imageOut = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Pixel[][] data = image.getData();
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Rgb currentRgb = data[i][j].getRgb();
                int r = currentRgb.r();
                int g = currentRgb.g();
                int b = currentRgb.b();
                imageOut.setRGB(i, j, (r << 16) + (g << 8) + b);
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
