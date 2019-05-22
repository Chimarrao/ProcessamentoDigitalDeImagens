package afinamento;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class holt {

    public static BufferedImage holt(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Color cor = new Color(0, 0, 0);

        for (int x = 1; x < imagemRecebe.getWidth(); x++) {
            for (int y = 1; y < imagemRecebe.getHeight(); y++) {
                if (funcao(imagemRecebe, x, y) == false) {
                    cor = new Color(255, 255, 255);
                } else {
                    cor = new Color(0, 0, 0);
                }
                imagemRetorna.setRGB(x, y, cor.getRGB());
            }
        }
        return imagemRetorna;
    }

    public static Boolean funcao(BufferedImage imagemRecebe, int x, int y) {
        Boolean resultado;

        resultado = pixelAtual(imagemRecebe, x, y)
                && (!estaNaBorda(imagemRecebe, x, y) || (estaNaBorda(imagemRecebe, x + 1, y) && pixelAtual(imagemRecebe, x, y - 1) && pixelAtual(imagemRecebe, x, y + 1)))
                || (estaNaBorda(imagemRecebe, x, y + 1) && pixelAtual(imagemRecebe, x - 1, y) && pixelAtual(imagemRecebe, x + 1, y))
                || (estaNaBorda(imagemRecebe, x + 1, y) && estaNaBorda(imagemRecebe, x + 1, y + 1) && estaNaBorda(imagemRecebe, x, y + 1));

        return resultado;
    }

    public static Boolean pixelAtual(BufferedImage imagemRecebe, int x, int y) {
        Color cor = new Color(imagemRecebe.getRGB(x, y));
        int pixel = (cor.getRed() + cor.getBlue() + cor.getGreen()) / 3;

        if (pixel == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean estaNaBorda(BufferedImage imagemRecebe, int x, int y) {
        if (x == 0 || y == 0 || x == imagemRecebe.getWidth() || y == imagemRecebe.getHeight()) {
            return true;
        } else {
            return false;
        }
    }
}
