package edu.project4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class test {





    public static class ChaosGameFractal extends JFrame {
        private final int WIDTH = 800;
        private final int HEIGHT = 800;

        public ChaosGameFractal() {
            setTitle("fractal");
            setSize(WIDTH, HEIGHT);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            FractalPanel fractalPanel = new FractalPanel();
            add(fractalPanel);

        }



    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChaosGameFractal chaosGameFractal = new ChaosGameFractal();
            chaosGameFractal.setVisible(true);
        });
    }

    public static class FractalPanel extends JPanel {
        private final int POINTS = 1000000;
        private final int WIDTH = 800;
        private final int HEIGHT = 800;
        private final int POINT_SIZE = 1;
        private final Color POINT_COLOR = Color.black;


        private double x = 0.0;
        private double y = 0.0;

        private final double[][] functions = {
            {0.5, 0.0, 0.0, 0.0, 0.5, 0.0},
            {0.5, 0.0, 0.0, 0.0, 0.5, 0.0},
            {0.5, 0.0, 0.0, 0.0, 0.5, 0.0}
        };

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            for (int i = 0; i < POINTS; i++) {
                int randomIndex = (int) (Math.random() * functions.length);
                double[] function = functions[randomIndex];

                double newX = function[0] * x + function[1] * y + function[2];
                double newY = function[3] * x + function[4] * y + function[5];

                x = newX;
                y = newY;

                int pixelX = (int) (WIDTH / 2 + x * WIDTH / 4);
                int pixelY = (int) (HEIGHT / 2 + y * HEIGHT / 4);

                g2d.setColor(POINT_COLOR);
                g2d.fillRect(pixelX, pixelY, POINT_SIZE, POINT_SIZE);
            }
        }
    }


}
