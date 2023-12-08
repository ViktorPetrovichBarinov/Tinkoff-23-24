package edu.project4;

public class Pixel {
    private Rgb rgb;
    private int hitCount;
    private double normal;

    Pixel (Rgb rgb, int hitCount, double normal) {
        this.rgb = rgb;
        this.hitCount = hitCount;
        this.normal = normal;
    }

    public int getHitCount() {
        return hitCount;
    }

    public Rgb getRgb() {
        return rgb;
    }

    public double getNormal() {
        return normal;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public void setRgb(Rgb rgb) {
        this.rgb = rgb;
    }
}
