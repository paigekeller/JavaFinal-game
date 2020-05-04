//Paige Keller
//Power up Class

import javax.swing.*;
import java.awt.*;
public class Powerups
{
    protected int diameter, x, y;
    private Color pink = new Color(255,20,147);
    public Powerups(int diameter, int x, int y)
    {
        this.diameter = diameter;
        this.x = x;
        this.y = y;
    }
    
    public Powerups()
    {
        diameter = (int)(Math.random()*30 + 20); 
        x = (int)(Math.random()*400 + 2);
        y = (int)(Math.random()*400 + 2);
    }
    
    public void draw(Graphics circle)
    {
       circle.setColor(pink);
       circle.fillOval(x,y,diameter,diameter);
    }
    
        public int getXPlus()
    {
        return x+diameter;
    }
    
    public int getX()
    {
        return x;
    }
    
        public int getY()
    {
        return y;
    }
    
          public int getYPlus()
    {
        return y+diameter;
    }
    
        public int getDi()
    {
        return diameter;
    }
    
}