/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perlinnoise;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sushant
 */
public class PerlinNoise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        genTexture g = new genTexture();
        g.createImage();
        try {
            g.generateImage();
        } catch (IOException ex) {
            Logger.getLogger(PerlinNoise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
