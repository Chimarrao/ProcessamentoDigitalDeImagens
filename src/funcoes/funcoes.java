package funcoes;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class funcoes {

    public static int[] shellSort(int[] nums) {
        int h = 1;
        int n = nums.length;
        while (h < n) {
            h = h * 3 + 1;
        }
        h = h / 3;
        int c;
        int j;
        while (h > 0) {
            for (int i = h; i < n; i++) {
                c = nums[i];
                j = i;
                while (j >= h && nums[j - h] > c) {
                    nums[j] = nums[j - h];
                    j = j - h;
                }
                nums[j] = c;
            }
            h = h / 2;
        }
        return nums;
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