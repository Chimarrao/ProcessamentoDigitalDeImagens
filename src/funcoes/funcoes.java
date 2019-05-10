package funcoes;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class funcoes {

    public int[] shellSort(int[] vetor) {
        int h = 1;
        int n = vetor.length;
        while (h < n) {
            h = h * 3 + 1;
        }
        h = h / 3;
        int c;
        int j;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = vetor[i];
                j = i;
                while (j >= h && vetor[j - h] > c) {
                    vetor[j] = vetor[j - h];
                    j = j - h;
                }
                vetor[j] = c;
            }
            h = h / 2;
        }
        return vetor;
    }

    public BufferedImage copiaImagem(BufferedImage imagemRecebe) {
        ColorModel modeloCor = imagemRecebe.getColorModel();
        boolean alfa = modeloCor.isAlphaPremultiplied();
        WritableRaster rastreio = imagemRecebe.copyData(null);
        return new BufferedImage(modeloCor, rastreio, alfa, null);
    }

    public BufferedImage carregaImagem() {
        BufferedImage imagemRetorna = null;
        String pathArquivo = new String();
        final JFileChooser arquivo = new JFileChooser();
        int valorRetorno = arquivo.showOpenDialog(arquivo);
        if (valorRetorno == JFileChooser.APPROVE_OPTION) {
            pathArquivo = arquivo.getSelectedFile().getAbsolutePath();
        }
        try {
            imagemRetorna = ImageIO.read(new File(pathArquivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagemRetorna;
    }
}
