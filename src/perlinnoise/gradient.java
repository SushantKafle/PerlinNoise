/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perlinnoise;

/**
 *
 * @author sushant
 */
public class gradient {
    
    private float gx;
    private float gy;
    
    public gradient(float[] grad)
    {
        gx = grad[0];
        gy = grad[1];
    }
    
    public gradient(float gx,float gy)
    {
        this.gx = gx;
        this.gy = gy;
    }
    
    
    public float dot(gradient g)
    {
        return (g.getGX()*gx + g.getGY()*gy);
    }
    
    public float mag()
    {
        return (float)Math.sqrt(gx*gx + gy*gy);
    }
    
    public void log()
    {
        System.out.println(gx+" "+gy);
    }
    
    public float getGX()
    {
        return gx;
    }
    
    public float getGY()
    {
        return gy;
    }
}
