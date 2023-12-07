package edu.project4.Render;

import edu.project4.Rgb;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AffineTransformationGenerator {
    private final int countOfAffineTransformations;
    private final Random random;
    private final List<AffineTransformation> affineTransformations;

    public AffineTransformationGenerator(int countOfAffineTransformations, long seed) {
        this.countOfAffineTransformations = countOfAffineTransformations;
        random = new Random(seed);
        affineTransformations = new ArrayList<>();
    }

    public List<AffineTransformation> affineTransformationsGenerator() {
        for (int i = 0; i < countOfAffineTransformations; i++) {
            int rColor, gColor, bColor;
            double aI, bI, cI, dI, eI, fI;

            while(true) {
                aI = generateRandCoefficient(random);
                bI = generateRandCoefficient(random);
                cI = generateRandCoefficient(random);
                dI = generateRandCoefficient(random);
                eI = generateRandCoefficient(random);
                fI = generateRandCoefficient(random);

                if ((aI * aI + dI * dI >= 1)
                    || (bI * bI + eI * eI >= 1)
                    || (aI * aI + bI * bI + dI * dI + eI * eI >= 1 + Math.pow(aI * eI - bI * dI, 2))) {
                    continue;
                }

                break;
            }

            rColor = generateRandColor(random);
            gColor = generateRandColor(random);
            bColor = generateRandColor(random);

            Rgb rgb = new Rgb(rColor, gColor, bColor);
            AffineTransformation affineTransformation = new AffineTransformation(rgb, aI, bI, cI, dI, eI, fI);

            affineTransformations.add(affineTransformation);

        }

        return affineTransformations;
    }


    private static double generateRandCoefficient(Random random) {
        return random.nextDouble() * 2.0 - 1.0;
    }

    private static int generateRandColor(Random random) {
        return random.nextInt(256);
    }

}
