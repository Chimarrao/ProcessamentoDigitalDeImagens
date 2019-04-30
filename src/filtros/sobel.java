package filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class sobel {
    //Mascaras para sobel
    private static int[][] xKernel = new int[][]{
        {1,0,-1 },
	{2,0,-2 },
	{1,0,-1}
    };  
    private static int[][] yKernel = new int[][]{
        {1,2,1},
	{0,0,0},
	{-1,-2,-1}
    };  

    public static BufferedImage sobel(BufferedImage imagemRecebe) {
        BufferedImage imagemRetorna = new BufferedImage(
                imagemRecebe.getWidth(null),
                imagemRecebe.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Color cor = new Color(0, 0, 0);
        double gx = 0, gy = 0, valorPixel = 0, auxCalculo = 0;
        
        for (int x = 1; x < imagemRecebe.getWidth() - 1; x++) {
            for (int y = 1; y < imagemRecebe.getHeight() - 1; y++) {
                gx = 0;
                gy = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        cor = new Color(imagemRecebe.getRGB(x + (i - 1), y + (j - 1)));
                        valorPixel = (cor.getRed() + cor.getBlue() + cor.getGreen()) / 3;
                        gx = gx + valorPixel * xKernel[i][j];
                        gy = gy + valorPixel * yKernel[i][j];
                    }
                }
                auxCalculo = Math.sqrt(Math.pow(gx, 2) + Math.pow(gy, 2));
                
                int Threshold = 60;
                
                if (auxCalculo > Threshold){
                    cor = new Color(255, 255, 255);
                }else{
                    cor = new Color(0, 0, 0);
                }
                imagemRetorna.setRGB(x, y, cor.getRGB());
            }
        }
        return imagemRetorna;
    }    
}
