package filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class mediana {

    //Mascara para mediana
    private static Color[][] mascara = new Color[][]{
        {Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE},
        {Color.WHITE, Color.WHITE, Color.WHITE}
    };

    public static BufferedImage mediana(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Color cor = new Color(0, 0, 0);
        int r = 0, g = 0, b = 0;

        for (int x = 1; x < imagemRecebe.getWidth() - 1; x++) {
            for (int y = 1; y < imagemRecebe.getHeight() - 1; y++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        cor = new Color(imagemRecebe.getRGB(x + (i - 1), y + (j - 1)));
                        mascara[i][j] = cor;
                    }
                }
                cor = new Color(r, g, b);
                cor = populaVetor();
                imagemRetorna.setRGB(x, y, cor.getRGB());
            }
        }
        return imagemRetorna;
    }

    //Popula o vetor que será organizado
    public static Color populaVetor() {
        Color[] vetor = new Color[10];
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                vetor[cont] = mascara[i][j];
                cont++;
            }
        }
        Color color = new Color(0, 0, 0);
        color = bubbleSort(vetor);
        return color;
    }

    //Organiza o vetor e pega o elemento central da matriz 3x3
    public static Color bubbleSort(Color vetor[]) {
        Color color = new Color(0, 0, 0);
        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                Integer anterior = 0, atual = 0;
                try {
                    anterior = anterior + (int) vetor[j - 1].getRed();
                    anterior = anterior + (int) vetor[j - 1].getGreen();
                    anterior = anterior + (int) vetor[j - 1].getBlue();

                    atual = atual + (int) vetor[j].getRed();
                    atual = atual + (int) vetor[j].getGreen();
                    atual = atual + (int) vetor[j].getBlue();

                    //Faz a troca
                    if (anterior > atual) {
                        Color aux = vetor[j];
                        vetor[j] = vetor[j - 1];
                        vetor[j - 1] = aux;
                    }
                } catch (Exception ex) {
                }
            }
        }
        if (vetor[5] != null) {
            color = vetor[5];
        }
        return color;
    }
}
