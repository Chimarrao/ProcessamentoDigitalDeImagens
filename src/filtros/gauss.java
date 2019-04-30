package filtros;

import static filtros.filtrosRuidos.checkPixel;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class gauss {
    //Mascara para Gauss
    private static int[][] mascaraGauss = new int[][]{
        {1, 2, 1},
        {2, 4, 2},
        {1, 2, 1}
    };

    public static BufferedImage gauss(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        
        Color cor = new Color(0,0,0);
        
        for (int x = 1; x < imagemRecebe.getWidth() - 1; x++) {
            for (int y = 1; y < imagemRecebe.getHeight() - 1; y++) {
                int r = 0, g = 0, b = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        cor = new Color(imagemRecebe.getRGB(x + (i - 1), y + (j - 1)));
                        r = r + cor.getRed() * mascaraGauss[i][j];
                        g = g + cor.getGreen() * mascaraGauss[i][j];
                        b = b + cor.getBlue() * mascaraGauss[i][j];
                    }
                }
                r = r / 16;
                g = g / 16;
                b = b / 16;
                r = checkPixel(r);
                g = checkPixel(g);
                b = checkPixel(b);

                cor = new Color(r, g, b);
                imagemRetorna.setRGB(x, y, cor.getRGB());
            }
        }
        return imagemRetorna;
    }
}
