package converte;

import funcoes.funcoes;
import java.awt.image.BufferedImage;

public class escalaCinza {
    int medianaCount;
    int moda;
    int valor_variancia = 0;
    int repetModa;
    int mediana;
    double med = 0;
    int histograma[] = new int[256];

    public BufferedImage converter(BufferedImage imagemRecebe) {
        funcoes funcoes = new funcoes();
        BufferedImage imagemRetorna = funcoes.copiaImagem(imagemRecebe);
        
        int largura = imagemRecebe.getWidth();
        int altura = imagemRecebe.getHeight();

        int[] mediana = new int[largura * altura];

        int[][] matrizPixel = new int[altura][largura];
        int[][] matrizColorida = new int[altura][largura];
      
        int count = 0;
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int pixel = imagemRecebe.getRGB(x, y);

                int alpha = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                int media = (r + g + b) / 3;

                matrizColorida[y][x] = media;

                mediana[count] = media;
                setMediana(mediana[count]);

                pixel = (alpha << 24) | (media << 16) | (media << 8) | media;

                matrizPixel[y][x] = pixel;
                if (y > altura / 2) {
                    histograma[media]++;
                } else {
                    med = med + media;
                }
                count++;
                imagemRetorna.setRGB(x, y, pixel);
            }
        }
        mediana = funcoes.shellSort(mediana);

        //Soma de todos os pixeis dividido por eles
        med = med / ((largura * altura) / 2);

        medianaCount = mediana[count / 2];

        moda = 0;
        for (int i = 0; i < 255; i++) {
            if (histograma[i] > histograma[moda]) {
                moda = i;
            }
        }
        calculaVariancia(matrizPixel);
        return imagemRetorna;
    }

    public void criaGraficoHistograma() {
        ///
    }

    public double calculaVariancia(int matrizPixel[][]) {
        Double media = med;

        for (int i = 0; i < matrizPixel.length; i++) {
            for (int j = 0; j < matrizPixel[0].length; j++) {
                valor_variancia += (matrizPixel[i][j] - media) * (matrizPixel[i][j] - media);
            }
        }
        valor_variancia = valor_variancia / (matrizPixel.length * matrizPixel[0].length);
        return valor_variancia;
    }

    public int getModa() {
        return moda;
    }

    public int getVariancia() {
        return valor_variancia;
    }

    public int getMediana() {
        return medianaCount;
    }

    public void setMediana(int mediana) {
        this.mediana = mediana;
    }

    public double getMedia() {
        return med;
    }
}
