package filtros;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class media {
    //Mascara para média
    private static int[][] mascara = new int[][]{
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };

    public static BufferedImage media(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Color cor = new Color(0, 0, 0);
        int r = 0, g = 0, b = 0;
        
        for (int x = 1; x < imagemRecebe.getWidth() - 1; x++) {
            for (int y = 1; y < imagemRecebe.getHeight() - 1; y++) {
                r = 0; g = 0; b = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        cor = new Color(imagemRecebe.getRGB(x + (i - 1), y + (j - 1)));
                        r = r + cor.getRed() * mascara[i][j];
                        g = g + cor.getGreen() * mascara[i][j];
                        b = b + cor.getBlue() * mascara[i][j];
                    }
                }
                r = r / 9; g = g / 9; b = b / 9;
                r = checkPixel(r);
                g = checkPixel(g);
                b = checkPixel(b);

                cor = new Color(r, g, b);
                imagemRetorna.setRGB(x, y, cor.getRGB());
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
