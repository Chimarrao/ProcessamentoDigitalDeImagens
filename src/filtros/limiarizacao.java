package filtros;

import java.awt.image.BufferedImage;
import converte.escalaCinza;
import java.awt.Color;

public class limiarizacao {

    public BufferedImage limiarizacao(BufferedImage imagemRecebe) {
        int largura = imagemRecebe.getWidth();
        int altura = imagemRecebe.getHeight();

        escalaCinza escCinza = new escalaCinza();
        BufferedImage imagemRetorna = escCinza.copiaImagem(imagemRecebe);
        
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                
                Color cor = new Color(imagemRecebe.getRGB(x, y));
                int pixel = (cor.getRed() + cor.getBlue() + cor.getGreen()) / 3;
                
                if(pixel > 60){
                    cor = new Color(255,255,255);
                }else{
                    cor = new Color(0,0,0);
                }
                
                imagemRetorna.setRGB(x, y, cor.getRGB());
            }
        }
        return imagemRetorna;
    }
}
