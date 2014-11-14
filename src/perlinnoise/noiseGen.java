/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perlinnoise;

import java.util.Random;

/**
 *
 * @author sushant
 */
public class noiseGen {
    
    private final int patHeight = 256;
    private final int patWidth = 256;
    private final gradient g[][] = new gradient[patHeight][patWidth]; //[w][h]
    
    Random rand = new Random();
    
    public noiseGen()
    {
        generateGradients();
    }
    
    public float whiteNoise()
    {
        return rand.nextFloat();
    }
    
    public float noise2D(float x, float y)
    {
        int x0 = (int) Math.floor(x);
        int x1 = (int) Math.ceil(x);
        
        int y0 = (int) Math.floor(y);
        int y1 = (int) Math.ceil(y);
        
        gradient vec00 = new gradient(x-x0,y-y0);
        gradient vec01 = new gradient(x-x0,y-y1);
        gradient vec10 = new gradient(x-x1,y-y0);
        gradient vec11 = new gradient(x-x1,y-y1);

        float s = vec00.dot(g[x0][y0]);
        float t = vec10.dot(g[x1][y0]);
        float u = vec01.dot(g[x0][y1]);
        float v = vec11.dot(g[x1][y1]);
        
        //return (float)((((s+t)*0.5)+((u+v)*0.5))*0.5);
        
        //3p^2 - 2p^3
        float Sx = smoothParam(x-x0);
        float ax = s + Sx*(t - s);
        float bx = u + Sx*(v - u);
        
        float Sy = smoothParam(y-y0);
        
        return ax + Sy*(bx - ax);
    }
    
    public float PerlinNoise2D(float x, float y)
    {
        float total = 0;
        float p = 0.25f;
        int n = 4;
        
        for(int i=0;i<n;i++)
        {
            float freq = (float)Math.pow(2, i);
            float amp = (float)Math.pow(p, i);
            
            total += noise2D((x*freq)/n,(y*freq)/n)*amp;
        }
        
        
        return total;
    }
    
    public final void generateGradients()
    {
        for(int h=0;h<patHeight;h++)
        {
            for(int w=0;w<patWidth;w++)
            {
                float t1 = rand.nextFloat();
                float t2 = rand.nextFloat();
                g[w][h]=new gradient(puff(t1,t2));
            }
        }
    }
    
    public float[] puff(float t1,float t2)
    {   
        
        float sqrt = (float) Math.sqrt((t1*t1)+(t2*t2));
        
        return new float[]{t1/sqrt,t2/sqrt};
    }
    
    
    public float smoothParam(float p)
    {
        return ((3*p*p)-(2*p*p*p));
    }
    
}
