package filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class filtrosRuidos {

    //Mascara para média
    private static int[][] mascaraMedia = new int[][]{
        {1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}
    };

    //Mascara para mediana
    private static Color[][] mascaraMediana = new Color[][]{
        {Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE}
    };

    //Mascara para Gauss
    private static int[][] mascaraGauss = new int[][]{
        {1, 2, 1},
        {2, 4, 2},
        {1, 2, 1}
    };    

    public static BufferedImage media(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        for (int x = 1; x < imagemRecebe.getWidth() - 1; x++) {
            for (int y = 1; y < imagemRecebe.getHeight() - 1; y++) {
                int r = 0, g = 0, b = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        Color color = new Color(imagemRecebe.getRGB(x + (i - 1), y + (j - 1)));
                        r = r + color.getRed() * mascaraMedia[i][j];
                        g = g + color.getGreen() * mascaraMedia[i][j];
                        b = b + color.getBlue() * mascaraMedia[i][j];
                    }
                }
                r = r / 9;
                g = g / 9;
                b = b / 9;
                r = checkPixel(r);
                g = checkPixel(g);
                b = checkPixel(b);

                Color color = new Color(r, g, b);
                imagemRetorna.setRGB(x, y, color.getRGB());
            }
        }
        return imagemRetorna;
    }

    public static BufferedImage mediana(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        for (int x = 1; x < imagemRecebe.getWidth() - 1; x++) {
            for (int y = 1; y < imagemRecebe.getHeight() - 1; y++) {
                int r = 0, g = 0, b = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        Color color = new Color(imagemRecebe.getRGB(x + (i - 1), y + (j - 1)));
                        mascaraMediana[i][j] = color;
                    }
                }
                Color color = new Color(r, g, b);
                color = populaVetor();
                imagemRetorna.setRGB(x, y, color.getRGB());
            }
        }
        return imagemRetorna;
    }
    
    public static BufferedImage gauss(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        for (int x = 1; x < imagemRecebe.getWidth() - 1; x++) {
            for (int y = 1; y < imagemRecebe.getHeight() - 1; y++) {
                int r = 0, g = 0, b = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        Color color = new Color(imagemRecebe.getRGB(x + (i - 1), y + (j - 1)));
                        r = r + color.getRed() * mascaraGauss[i][j];
                        g = g + color.getGreen() * mascaraGauss[i][j];
                        b = b + color.getBlue() * mascaraGauss[i][j];
                    }
                }
                r = r / 16;
                g = g / 16;
                b = b / 16;
                r = checkPixel(r);
                g = checkPixel(g);
                b = checkPixel(b);

                Color color = new Color(r, g, b);
                imagemRetorna.setRGB(x, y, color.getRGB());
            }
        }
        return imagemRetorna;
    }

    public static Color populaVetor() {
        Color[] vetor = new Color[10];
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                vetor[cont] = mascaraMediana[i][j];
                cont ++;
            }
        }
        Color color = new Color(0,0,0);
        color = bubbleSort(vetor);
        return color;
    }

    public static Color bubbleSort(Color v[]) {
        Color color = new Color(0,0,0);
        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                Integer anterior = 0, atual = 0;
                try {
                    anterior = anterior + (int) v[j - 1].getRed();
                    anterior = anterior + (int) v[j - 1].getGreen();
                    anterior = anterior + (int) v[j - 1].getBlue();
                    
                    atual = atual + (int) v[j].getRed();
                    atual = atual + (int) v[j].getGreen();
                    atual = atual + (int) v[j].getBlue();
                    
                    if (anterior > atual) {
                        Color aux = v[j];
                        v[j] = v[j - 1];
                        v[j - 1] = aux;
                    }
                } catch (Exception ex) {
                }
            }
        }
        if(v[5] != null){
            color = v[5];
        }
        return color;
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
