package edu.project4;

public class FractalImage {
    private int width;
    private int height;
    private Pixel[][] data;

    public FractalImage(int width, int height) {
        data = new Pixel[width][height];
        this.height = height;
        this.width = width;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Pixel pixel = new Pixel(new Rgb(0, 0, 0), 0, 0);
                data[i][j] = pixel;
            }
        }
    }
    public void update(Point point, Rgb addRgb) {
        if ((int)point.x() >= width || (int)point.y() >= height) {
            return;
        }
        Pixel pixel = data[(int) point.x()][(int) point.y()];
        Rgb rgb = pixel.getRgb();
        int r = (rgb.r() * pixel.getHitCount() + addRgb.r()) / (pixel.getHitCount() + 1);
        int g = (rgb.g() * pixel.getHitCount() + addRgb.g()) / (pixel.getHitCount() + 1);
        int b = (rgb.b() * pixel.getHitCount() + addRgb.b()) / (pixel.getHitCount() + 1);

        Pixel newData = new Pixel(new Rgb(r, g, b), pixel.getHitCount() + 1, 0);
        data[(int) point.x()][(int) point.y()] = newData;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Pixel[][] getData() {
        return data;
    }
}
