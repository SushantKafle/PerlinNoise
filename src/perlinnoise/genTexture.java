/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perlinnoise;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sushant
 */
public class genTexture {
    
    private BufferedImage img;
    private noiseGen gen;
    
    public void createImage()
    {
        gen = new noiseGen();
        img = new BufferedImage(256, 256,BufferedImage.TYPE_INT_RGB);
    }
    
    public void generateImage() throws IOException
    {
        for(int i=0;i<256;i++)
        {
            for(int j=0;j<256;j++)
            {
                float noise = gen.PerlinNoise2D((i/50.f),(j/50.f)); //gen.whiteNoise();
                int g =0;
                int r =Math.abs((int)(255 * noise));
                int b =0;
                int col = (r << 16) | (g << 8) | b;
                
                img.setRGB(i, j,(int)(col*3));
            }
        }
        
        File f = new File("PerlinNoise.png");
        if (!ImageIO.write(img, "JPEG", f)) {
            throw new RuntimeException("Unexpected error writing image");
        }
    }
    
}
