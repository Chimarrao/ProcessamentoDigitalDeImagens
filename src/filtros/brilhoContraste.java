package filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class brilhoContraste {
    public static BufferedImage brilhoContraste(BufferedImage imagemRecebe, float contrastePercentual, int brilhoPercentual) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        
        for (int x = 0; x < imagemRecebe.getWidth(); x++) {
            for (int y = 0; y < imagemRecebe.getHeight(); y++) {
                Color color = new Color(imagemRecebe.getRGB(x, y));
                int r, g, b;
                
                r = checkPixel((int) (contrastePercentual * color.getRed() + brilhoPercentual));
                g = checkPixel((int) (contrastePercentual * color.getGreen() + brilhoPercentual));
                b = checkPixel((int) (contrastePercentual * color.getBlue() + brilhoPercentual));
                
                color = new Color(r, g, b);
                imagemRetorna.setRGB(x, y, color.getRGB());
            }
        }
        return imagemRetorna;
    }

    public static int checkPixel(int novaCor) {
        if (novaCor > 255) {
            novaCor = 255;
        } else if (novaCor < 0) {
            novaCor = 0;
        }
        return novaCor;
    }
}
