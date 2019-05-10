package transformacaoGeometrica;

import java.awt.image.BufferedImage;

public class transformacaoGeometrica {

    public transformacaoGeometrica() {
    }

    public BufferedImage transforma_imagem(BufferedImage imagemRecebe) {
        int largura = imagemRecebe.getWidth();
        int altura = imagemRecebe.getHeight();

        BufferedImage imagemRetorna = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        // Para redimensionamento
        double escalaX = matrizControle[0][0];
        double escalaY = matrizControle[1][1];
        // Para rotação
        double angulo = matrizControle[2][1];
        // Para movimentação
        int offsetX = (int) matrizControle[0][2];
        int offsetY = (int) matrizControle[1][2];
        // Para o espelhamento
        int espelhaX = (int) matrizControle[1][0];
        int espelhaY = (int) matrizControle[0][1];

        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                // Calcula o centro da imagem
                int centroX = (int) (largura / 2 * escalaX) - offsetX;
                int centroY = (int) (altura / 2 * escalaY) - offsetY;
                // Calcula o redimensionamento e offset
                int _posX = (int) (x / escalaX) - offsetX;
                int _posY = (int) (y / escalaY) - offsetY;
                // Calcula o ângulo de rotação
                int posX = centroX + espelhaX * (int) (Math.cos(angulo) * (_posX - centroX) - Math.sin(angulo) * (_posY - centroY));
                int posY = centroY + espelhaY * (int) (Math.sin(angulo) * (_posX - centroX) + Math.cos(angulo) * (_posY - centroY));
                // Sai da iteração caso tranborde
                if (posX >= largura || posX < 0
                        || posY >= altura || posY < 0) {
                    continue;
                }
                imagemRetorna.setRGB(x, y, imagemRecebe.getRGB(posX, posY));
            }
        }

        return imagemRetorna;
    }

    // Espelhamento de imagem
    //  1 -> normal
    // -1 -> espelhado
    public BufferedImage espelha_horizontal(BufferedImage img) {
        matrizControle[1][0] *= -1;
        return transforma_imagem(img);
    }

    public BufferedImage espelha_vertical(BufferedImage img) {
        matrizControle[0][1] *= -1;
        return transforma_imagem(img);
    }

    public BufferedImage rotaciona_imagem(BufferedImage img, double angulo) {
        matrizControle[2][1] = Math.toRadians(angulo);
        return transforma_imagem(img);
    }

    public BufferedImage move_imagem(BufferedImage img, int offsetX, int offsetY) {
        matrizControle[0][2] = offsetX;
        matrizControle[1][2] = offsetY;
        return transforma_imagem(img);
    }

    public BufferedImage redimensiona_imagem(BufferedImage img, double escala) {
        matrizControle[0][0] = matrizControle[1][1] = (escala / 100);
        return transforma_imagem(img);
    }

    private final double matrizControle[][] = {{1, 1, 0},
                                              {1, 1, 0},
                                              {0, 0, 1}};
}
